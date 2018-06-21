package nl.hu.ipass.gitaarshop.webservices;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import nl.hu.ipass.gitaarshop.model.PersonService;
import nl.hu.ipass.gitaarshop.model.ServiceProvider;

@Path("/account")
public class MakeAccount {
	
	@POST
	@Produces("application/json")
	public Response addAccount(@Context SecurityContext sc, @FormParam("email") String email, @FormParam("firstname") String firstname, 
			@FormParam("lastname") String lastname, @FormParam("city") String city, @FormParam("zip_code") String zip_code, @FormParam("password")String password, 
			@FormParam("phone_number")String phone_number, @FormParam("role")String role) throws ClassNotFoundException, SQLException {
		PersonService service = ServiceProvider.getPersonService();
		if(service.newUser(email, firstname, lastname, city, zip_code, password, phone_number, role)) {
			return Response.ok().build();
		}
		
		return Response.status(409).build();
		}
}
