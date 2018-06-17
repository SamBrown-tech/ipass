package nl.hu.v1wac.firstapp.persistence;

import nl.hu.v1wac.firstapp.model.Country;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.v1wac.firstapp.model.Country;

public class CountryDaoPostgresImpl extends PostgresBaseDao implements CountryDao {

	@Override
	public boolean save(String code, String iso3, String nm, String cap, String ct, String reg, double sur, int pop, String gov, double lat, double lng) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        if(code != null) {
            String insert = "INSERT INTO COUNTRY (CODE, ISO3, NAME, CONTINENT, REGION, SURFACEAREA, INDEPYEAR, POPULATION, LIFEEXPECTANCY, GNP, GNPOLD, LOCALNAME, GOVERNMENTFORM, HEADOFSTATE, LATITUDE, LONGITUDE, CAPITAL)"
            		+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stat = conn.prepareStatement(insert);
            stat.setString(1, code);
            stat.setString(2, iso3);
            stat.setString(3, nm);
            stat.setString(4, ct);
            stat.setString(5, reg);
            stat.setDouble(6, sur);
            stat.setInt(7, 1990);
            stat.setInt(8, pop);
            stat.setInt(9, 88);
            stat.setDouble(10, 1234);
            stat.setDouble(11, 4314);
            stat.setString(12, "kak");
            stat.setString(13, gov);
            stat.setString(14, "Niek Hamoen");
            stat.setDouble(15, lat);
            stat.setDouble(16, lng);
            stat.setString(17, cap);
            stat.executeUpdate();
            System.out.println(nm + " is toegevoegd\n");
            return true;
        }
        return false;
    }
    
    public List<Country> findAll() throws SQLException, ClassNotFoundException {
        ArrayList<Country> lijst_landen = new ArrayList<Country>();
        Connection conn = getConnection();


        String query = "SELECT * FROM country";
        PreparedStatement stat = conn.prepareStatement(query);
        ResultSet rs = stat.executeQuery();

        while (rs.next()) {
            Country country = new Country();
            country.setCode(rs.getString("CODE"));
            country.setIso3(rs.getString("ISO3"));
            country.setName(rs.getString("NAME"));
            country.setContinent(rs.getString("CONTINENT"));
            country.setRegion(rs.getString("REGION"));
            country.setSurface(rs.getDouble("SURFACEAREA"));
            country.setPopulation(rs.getInt("POPULATION"));
            country.setGovernment(rs.getString("GOVERNMENTFORM"));
            country.setLatitude(rs.getInt("LATITUDE"));
            country.setLongitude(rs.getInt("LONGITUDE"));
            country.setCapital(rs.getString	("CAPITAL"));
            lijst_landen.add(country);
        }

        return lijst_landen;
    }


    public Country findByCode(String code) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        String query = "SELECT * FROM country WHERE code="+ "'"+code+"'";

        PreparedStatement stat = conn.prepareStatement(query);
        ResultSet rs = stat.executeQuery();
        Country country = new Country();
        while (rs.next()) {
            country.setCode(rs.getString("CODE"));
            country.setIso3(rs.getString("ISO3"));
            country.setName(rs.getString("NAME"));
            country.setContinent(rs.getString("CONTINENT"));
            country.setRegion(rs.getString("REGION"));
            country.setSurface(rs.getDouble("SURFACEAREA"));
            country.setPopulation(rs.getInt("POPULATION"));
            country.setGovernment(rs.getString("GOVERNMENTFORM"));
            country.setLatitude(rs.getInt("LATITUDE"));
            country.setLongitude(rs.getInt("LONGITUDE"));
            country.setCapital(rs.getString	("CAPITAL"));
        }
        System.out.println("De naam van het land is "+country.getName());
        return country;
    }
    

    public List<Country> find10LargestPop() throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        ArrayList<Country> lijst_landen = new ArrayList<Country>();

        String query = "SELECT * FROM country ORDER BY population DESC LIMIT 10";

        PreparedStatement stat = conn.prepareStatement(query);
        ResultSet rs = stat.executeQuery();

        while (rs.next()) {
            Country country = new Country();
            country.setCode(rs.getString("CODE"));
            country.setIso3(rs.getString("ISO3"));
            country.setName(rs.getString("NAME"));
            country.setContinent(rs.getString("CONTINENT"));
            country.setRegion(rs.getString("REGION"));
            country.setSurface(rs.getDouble("SURFACEAREA"));
            country.setPopulation(rs.getInt("POPULATION"));
            country.setGovernment(rs.getString("GOVERNMENTFORM"));
            country.setLatitude(rs.getInt("LATITUDE"));
            country.setLongitude(rs.getInt("LONGITUDE"));
            country.setCapital(rs.getString	("CAPITAL"));
            lijst_landen.add(country);
        }

        return lijst_landen;
    }


    public List<Country> find10LargestSurf() throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        ArrayList<Country> lijst_landen = new ArrayList<Country>();

        String query = "SELECT * FROM country ORDER BY surfacearea DESC LIMIT 10";
        PreparedStatement stat = conn.prepareStatement(query);
        ResultSet rs = stat.executeQuery();


        while (rs.next()) {
            Country country = new Country();
            country.setCode(rs.getString("CODE"));
            country.setIso3(rs.getString("ISO3"));
            country.setName(rs.getString("NAME"));
            country.setContinent(rs.getString("CONTINENT"));
            country.setRegion(rs.getString("REGION"));
            country.setSurface(rs.getDouble("SURFACEAREA"));
            country.setPopulation(rs.getInt("POPULATION"));
            country.setGovernment(rs.getString("GOVERNMENTFORM"));
            country.setLatitude(rs.getInt("LATITUDE"));
            country.setLongitude(rs.getInt("LONGITUDE"));
            country.setCapital(rs.getString	("CAPITAL"));
            lijst_landen.add(country);
        }

        return lijst_landen;
    }


    public boolean update(String name, String capital, String region, double surface, int population, String code) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        if (code != null) {
            String query = "UPDATE COUNTRY SET NAME = ?, CAPITAL = ?, REGION = ?, SURFACEAREA = ?, POPULATION = ? WHERE CODE = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, name);
            stat.setString(2, capital);
            stat.setString(3, region);
            stat.setDouble(4, surface);
            stat.setInt(5, population);
            stat.setString(6, code);
            stat.executeUpdate();
            System.out.println(name+" is geupdate");
            return true;
        }
        return false;
    }
    
    public boolean delete(Country country) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        if(country != null) {
            String delete =  "DELETE FROM country WHERE code = ?";
            PreparedStatement stat = conn.prepareStatement(delete);
            stat.setString(1, country.getCode());
            System.out.println("Het land " + country.getName() + " is verwijderd\n");
            return stat.executeUpdate() == 1;
        }
        return false;
    }

}