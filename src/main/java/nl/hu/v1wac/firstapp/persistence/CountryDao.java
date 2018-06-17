package nl.hu.v1wac.firstapp.persistence;

import java.sql.SQLException;
import java.util.List;

import nl.hu.v1wac.firstapp.model.Country;

public interface CountryDao {

	public boolean save(String code, String iso3, String nm, String cap, String ct, String reg, double sur, int pop, String gov, double lat, double lng) throws SQLException, ClassNotFoundException;
	
	public List<Country> findAll() throws SQLException, ClassNotFoundException;
	
	public Country findByCode(String code) throws SQLException, ClassNotFoundException;
	
	public List<Country> find10LargestPop() throws SQLException, ClassNotFoundException;
	
	public List<Country> find10LargestSurf() throws SQLException, ClassNotFoundException;
	
	public boolean update(String name, String capital, String region, double surface, int population, String code) throws SQLException, ClassNotFoundException;
	
	public boolean delete(Country country) throws SQLException, ClassNotFoundException;

}