package nl.hu.v1wac.firstapp.model;

import java.sql.SQLException;
import java.util.List;

import nl.hu.v1wac.firstapp.persistence.*;

public class WorldService {
	public List<Country> getAllCountries() throws SQLException, ClassNotFoundException {
		CountryDaoPostgresImpl c1 = new CountryDaoPostgresImpl();
		return c1.findAll();
	}

	public boolean delete(Country country) throws SQLException, ClassNotFoundException{
		CountryDaoPostgresImpl c1 = new CountryDaoPostgresImpl();
		c1.delete(country);

		return c1.delete(country);
	}
	

	public List<Country> get10LargestPopulations() throws SQLException, ClassNotFoundException {
		CountryDaoPostgresImpl c1 = new CountryDaoPostgresImpl();
		c1.find10LargestPop();

		return c1.find10LargestPop();
	}

	public List<Country> get10LargestSurfaces() throws SQLException, ClassNotFoundException {
		CountryDaoPostgresImpl c1 = new CountryDaoPostgresImpl();
		c1.find10LargestSurf();

		return c1.find10LargestSurf();
	}

	public Country getCountryByCode(String code) throws SQLException, ClassNotFoundException {
		CountryDaoPostgresImpl c1 = new CountryDaoPostgresImpl();
		c1.findByCode(code);

		return c1.findByCode(code);
	}
	
	
//	public String findUserByRole(String name, String pass) throws SQLException, ClassNotFoundException{
//		UserPostgresDAOlmpl user = new UserPostgresDAOlmpl();
//		user.findRoleForUser(name, pass);
//		
//		return name;
//	}
	
	public boolean updateCountry(String name, String capital, String region, double surface, int population, String code) throws ClassNotFoundException, SQLException {
		CountryDaoPostgresImpl c1 = new CountryDaoPostgresImpl();
	        c1.update(name, capital, region, surface, population, code);

	        return true;
	}
	
	public boolean saveCountry(String code, String iso3, String nm, String cap, String ct, String reg, double sur, int pop, String gov, double lat, double lng) throws ClassNotFoundException, SQLException {
		CountryDaoPostgresImpl c1 = new CountryDaoPostgresImpl();
        c1.save(code, iso3, nm, cap, ct, reg, sur, pop, gov, lat, lng);
		return true;

	}
}