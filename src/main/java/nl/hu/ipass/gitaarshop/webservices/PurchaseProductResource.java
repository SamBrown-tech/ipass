package nl.hu.ipass.gitaarshop.webservices;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import nl.hu.ipass.gitaarshop.model.PersonService;
import nl.hu.ipass.gitaarshop.model.PurchaseProductService;
import nl.hu.ipass.gitaarshop.model.ServiceProvider;



@Path("/purchaseproduct/{email}{id}")
public class PurchaseProductResource {
	@POST
    @Produces("application/json")
	// Stores purchaseproduct in database
	public Response addProduct(@Context SecurityContext sc, @PathParam("id") int product_id,
			  @PathParam("email") String email) throws ClassNotFoundException, SQLException {
        PurchaseProductService service = ServiceProvider.getPurchaseProductService();
        System.out.println(" id " + product_id + " email " + email);
        
        PersonService personservice = ServiceProvider.getPersonService();
        
        int purchase_id = personservice.findIdOfUser(email);
        System.out.println(purchase_id + " is de id");
        
        if (service.save(product_id, 1, purchase_id)) {
            return Response.ok().build();
        }
        return Response.status(409).build();
    }
}	