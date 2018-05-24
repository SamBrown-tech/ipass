package nl.hu.v1wac.firstapp.webservices;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import nl.hu.v1wac.firstapp.model.Country;
import nl.hu.v1wac.firstapp.model.ServiceProvider;
import nl.hu.v1wac.firstapp.model.WorldService;

@Path("/countries")
public class WorldResource {
	WorldService ws = ServiceProvider.getWorldService();
	JsonArrayBuilder jab = Json.createArrayBuilder();
	JsonObjectBuilder job = Json.createObjectBuilder();
	
	@GET
	@Produces("application/json")
	public String getAllCountries() {
		for(Country c : ws.getAllCountries()) {
			job.add("code", c.getCode());
			job.add("iso3", c.getIso3());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("continent", c.getContinent());
			job.add("region", c.getRegion());
			job.add("surface", c.getSurface());
			job.add("population", c.getPopulation());
			job.add("government", c.getGovernment());
			job.add("lat", c.getLatitude());
			job.add("lng", c.getLongitude());
			jab.add(job);
		}	
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("{code}")
	@Produces("application/json")
	public String getCountryByCode(@PathParam("code") String code) {
		Country c = ws.getCountryByCode(code);
		job.add("code", c.getCode());
		job.add("iso3", c.getIso3());
		job.add("name", c.getName());
		job.add("capital", c.getCapital());
		job.add("continent", c.getContinent());
		job.add("region", c.getRegion());
		job.add("surface", c.getSurface());
		job.add("population", c.getPopulation());
		job.add("government", c.getGovernment());
		job.add("lat", c.getLatitude());
		job.add("lng", c.getLongitude());
		jab.add(job);
		
		JsonArray array = jab.build();
		return array.toString();	
	}
	
	@GET
	@Path("/largestsurfaces")
	@Produces("application/json")
	public String get10LargestSurfaces() {
		List<Country> CountryList = ws.get10LargestSurfaces();
		for(Country c : CountryList) {
			job.add("code", c.getCode());
			job.add("iso3", c.getIso3());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("continent", c.getContinent());
			job.add("region", c.getRegion());
			job.add("surface", c.getSurface());
			job.add("population", c.getPopulation());
			job.add("government", c.getGovernment());
			job.add("lat", c.getLatitude());
			job.add("lng", c.getLongitude());
			jab.add(job);
		}
		
		JsonArray array = jab.build();
		return array.toString();
		
	}
	
	@GET
	@Path("/largestpopulations")
	@Produces("application/json")
	public String get10LargestPopulations() {
		List<Country> CountryList = ws.get10LargestPopulations();
		for(Country c : CountryList){
			job.add("code", c.getCode());
			job.add("iso3", c.getIso3());
			job.add("name", c.getName());
			job.add("capital", c.getCapital());
			job.add("continent", c.getContinent());
			job.add("region", c.getRegion());
			job.add("surface", c.getSurface());
			job.add("population", c.getPopulation());
			job.add("government", c.getGovernment());
			job.add("lat", c.getLatitude());
			job.add("lng", c.getLongitude());
			jab.add(job);
		}
		
		JsonArray array = jab.build();
		return array.toString();		
	}
}













