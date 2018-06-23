package nl.hu.ipass.gitaarshop.webservices;

import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import nl.hu.ipass.gitaarshop.model.PurchaseProductService;
import nl.hu.ipass.gitaarshop.model.ServiceProvider;



@Path("/purchaseproduct")
public class PurchaseProductResource {
	@POST
    @Produces("application/json")
	// Stores purchaseproduct in database
	public Response addProduct(@Context SecurityContext sc, @FormParam("id") int product_id,
			  @FormParam("quantity") int quantity) throws ClassNotFoundException, SQLException {
        PurchaseProductService service = ServiceProvider.getPurchaseProductService();
        System.out.println(quantity + "  " + product_id);
        if (service.save(product_id, quantity)) {
            return Response.ok().build();
        }
        return Response.status(409).build();
    }
}	