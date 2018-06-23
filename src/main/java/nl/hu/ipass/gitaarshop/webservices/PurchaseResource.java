package nl.hu.ipass.gitaarshop.webservices;

import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.hu.ipass.gitaarshop.model.Purchase;
import nl.hu.ipass.gitaarshop.model.PurchaseService;
import nl.hu.ipass.gitaarshop.model.ServiceProvider;

@Path("/purchase")
public class PurchaseResource {

	@GET
    @Produces("application/json")
    public String getProducten() throws SQLException, ClassNotFoundException {
		PurchaseService service = ServiceProvider.getPurchaseService();
        JsonArrayBuilder jab = Json.createArrayBuilder();
        {

            for (Purchase purchase : service.findAll()) {
                JsonObjectBuilder job = Json.createObjectBuilder();
                job.add("name", purchase.getName());
                job.add("quantity", purchase.getQuantity());
                job.add("price", purchase.getPrice());
                job.add("email", purchase.getEmail());
                jab.add(job);
            }
            JsonArray array = jab.build();
            String s = array.toString();
            return s;
        }

    }
}
