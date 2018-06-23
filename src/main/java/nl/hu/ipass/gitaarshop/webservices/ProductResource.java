package nl.hu.ipass.gitaarshop.webservices;

import java.sql.SQLException;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import nl.hu.ipass.gitaarshop.model.Product;
import nl.hu.ipass.gitaarshop.model.ProductService;
import nl.hu.ipass.gitaarshop.model.ServiceProvider;

@Path("/products")
public class ProductResource {
	@GET
	@Produces("application/json")
	// Returns a list of all products
	public String getProducts() throws ClassNotFoundException, SQLException {
		ProductService service = ServiceProvider.getProductService();
		JsonArrayBuilder jab = Json.createArrayBuilder();

		// Loops through result and adds an object to the json array
		for (Product product : service.findAll()) {
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("product_id", product.getProductId());
			job.add("name", product.getName());
			job.add("description", product.getDescription());
			job.add("image", product.getImage());
			job.add("price", product.getPrice());
			jab.add(job);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	

	@POST
	@Produces("application/json")
	// Stores product in database
	public Response addProduct(@Context SecurityContext sc, @FormParam("name") String name,
			@FormParam("description") String description, @FormParam("image") String image,
			@FormParam("price") int price) throws ClassNotFoundException, SQLException {
		ProductService service = ServiceProvider.getProductService();

		if (service.save(name, description, image, price)) {
			return Response.ok().build();
		}
		return Response.status(409).build();
	}

	@PUT
	@Produces("application/json")
	// Updates product in database
	public Response updateProduct(@Context SecurityContext sc, @FormParam("id") int id, @FormParam("name") String name,
			@FormParam("description") String description, @FormParam("image") String image,
			@FormParam("price") int price) throws SQLException, ClassNotFoundException {
		ProductService service = ServiceProvider.getProductService();
		
		if (service.update(id, name, description, image, price)) {
			return Response.ok().build();
		}
		return Response.accepted().build();
	}

	@DELETE
	@Path("/{artikelnaam}")
	@Produces("application/json")
	// Delete product from database
	public Response deleteProduct(@Context SecurityContext sc, @PathParam("artikelnaam") String naam)
			throws SQLException, ClassNotFoundException {
		System.out.println("Dit geef ik mee: " + naam);
		ProductService service = ServiceProvider.getProductService();

		if (service.delete(naam)) {
			return Response.ok().build();
		}
		return Response.status(409).build();
	}

}