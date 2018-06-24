package nl.hu.ipass.gitaarshop.webservices;

import java.security.Key;
import java.sql.SQLException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.ipass.gitaarshop.persistence.personDao;
import nl.hu.ipass.gitaarshop.persistence.personDaoPostgresImpl;

@Path("/authentications")
public class AuthenticationResource {
	
	// Generates random key
	final static public Key key = MacProvider.generateKey();

	  @POST
	  @Produces(MediaType.APPLICATION_JSON)
	  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	  // To authenticate the user
	  public Response authenticateUser(@FormParam("email") String email, 
	                                   @FormParam("password") String password) throws ClassNotFoundException, SQLException {
	    try {
	      // Authenticate the user in the database
	      personDao dao = new personDaoPostgresImpl();
	      String role = dao.findRoleForUser(email, password);
	      
	      if (role == null) { throw new IllegalArgumentException("No user found!");  } 
	      
	      String token = createToken(email, role);

	      SimpleEntry<String, String> JWT = new SimpleEntry<String, String>("JWT", token);
	      return Response.ok(JWT).build();


	    } catch (JwtException | IllegalArgumentException e) 
	        { return Response.status(Response.Status.UNAUTHORIZED).build(); }
	  }
	  
	  // Creates a token
	  private String createToken(String email, String role) throws JwtException {
		    Calendar expiration = Calendar.getInstance();
		    expiration.add(Calendar.MINUTE, 30);
		  
		    // Builds the token and returns
		    return Jwts.builder()
		      .setSubject(email)
		      .setExpiration(expiration.getTime())
		      .claim("role", role)
		      .signWith(SignatureAlgorithm.HS512, key)
		      .compact();
		 }
}