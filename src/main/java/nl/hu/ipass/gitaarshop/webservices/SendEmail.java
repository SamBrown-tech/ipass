package nl.hu.ipass.gitaarshop.webservices;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/sendemail")
public class SendEmail {
	@POST
    @Produces("application/json")
    public Response getEmail(@FormParam("email") String email, @FormParam("onderwerp") String subject, @FormParam("message") String message) throws SQLException, ClassNotFoundException, IOException {
		System.out.println(email + subject + message);
		mailService mail = new mailService();
		
        if (email != null) {
        	if(mail.sendEmail(email, subject, message)) {
	            return Response.ok().build();
	
	        }
        }
        return Response.status(409).build();
    }	
}