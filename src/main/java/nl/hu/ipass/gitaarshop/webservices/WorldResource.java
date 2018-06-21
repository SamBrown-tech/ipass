package nl.hu.v1wac.firstapp.webservices;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
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

import nl.hu.v1wac.firstapp.model.Country;
import nl.hu.v1wac.firstapp.model.ServiceProvider;
import nl.hu.v1wac.firstapp.model.WorldService;


@Path("/countries")
public class WorldResource {

	@GET
	@Produces("application/json")
	public String getCountries() throws SQLException, ClassNotFoundException {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		{

			for (Country country : service.getAllCountries()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("Name", country.getName());
				job.add("Code", country.getCode());
				job.add("Capital", country.getCapital());
				job.add("Region", country.getRegion());
				job.add("Surface", country.getSurface());
				job.add("Population", country.getPopulation());
				job.add("Longitude", country.getLongitude());
				job.add("Latitude", country.getLatitude());
				jab.add(job);
			}
			JsonArray array = jab.build();
			String s = array.toString();
			return s;
		}

	}


	@GET
	@Path("/largestsurfaces")
	@Produces("application/json")
	public String getLargestSurfaces() throws SQLException, ClassNotFoundException {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		{

			for (Country country : service.get10LargestSurfaces()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("Name", country.getName());
				job.add("Surface", country.getSurface());
				jab.add(job);
			}
			JsonArray array = jab.build();
			String s = array.toString();
			return s;
		}

	}

	@GET
	@Path("/largestpopulation")
	@Produces("application/json")
	public String getLargestPopulation() throws SQLException, ClassNotFoundException {
		WorldService service = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		{

			for (Country country : service.get10LargestPopulations()) {
				JsonObjectBuilder job = Json.createObjectBuilder();
				job.add("Name", country.getName());
				job.add("Population", country.getPopulation());
				jab.add(job);
			}
			JsonArray array = jab.build();
			String s = array.toString();
			return s;
		}

	}

	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getCountryByCode(@PathParam("code") String code) throws SQLException, ClassNotFoundException {
		WorldService service = ServiceProvider.getWorldService();
		Country country = service.getCountryByCode(code);
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("Name", country.getName());
		job.add("Capital", country.getCapital());
		job.add("Code", country.getCode());
		job.add("Population", country.getPopulation());
		job.add("Continent", country.getContinent());
		job.add("Government", country.getGovernment());
		job.add("Iso3", country.getIso3());
		job.add("Latidude", country.getLatitude());
		job.add("Longitude", country.getLongitude());
		job.add("Region", country.getRegion());
		job.add("Surface", country.getSurface());

		JsonObject object = job.build();
		String s = object.toString();
		return s;
	}
}