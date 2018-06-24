package nl.hu.ipass.gitaarshop.webservices;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import nl.hu.ipass.gitaarshop.model.PersonService;
import nl.hu.ipass.gitaarshop.model.ServiceProvider;

@Path("/account")
public class PersonResource {
	@POST
	@Produces("application/json")
	// Stores a new user in database
	public Response newUser(@Context SecurityContext sc, @FormParam("email") String email,
			@FormParam("firstname") String firstname, @FormParam("lastname") String lastname,
			@FormParam("makepass") String password) throws ClassNotFoundException, SQLException {
		System.out.println("beginfunctie");
		PersonService service = ServiceProvider.getPersonService();
		if (service.newUser(email, firstname, lastname, password)) {
			System.out.println("beginfunctie2");
			return Response.ok().build();
		}

		return Response.status(409).build();
	}
}
