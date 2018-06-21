package nl.hu.ipass.gitaarshop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class personPostgresDAOImpl extends PostgresBaseDao implements personDAO {

    @Override
    public String findRoleForUser(String email, String password) throws ClassNotFoundException {
        String query = ("SELECT role FROM person WHERE email= '" + email + "'and password = '" + password + "'");
        String role = null;
        try (Connection con = super.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                role = rs.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(role);
        return role;
    }
    
    @Override
    public boolean newUser( String email, String firstname, String lastname, String city, String zip_code,
    						String password, String phone_number, String role) throws ClassNotFoundException, SQLException {
    	Connection con = super.getConnection();
    	String query = ("INSERT INTO into person (email, firstname, lastname, city, zip_code, password, phone_number, role)\r\n" + 
    			"VALUES (?, ?, ?, ?, ?, 'user')");
    	if(email != null && firstname != null && lastname != null && password != null && role != null){
    		   PreparedStatement stat = con.prepareStatement(query);
    		   stat.setString(1, email);
    		   stat.setString(2, firstname);
    		   stat.setString(3, lastname);
    		   stat.setString(4, city);
    		   stat.setString(5, zip_code);
    		   stat.setString(6, password);
    		   stat.setString(7, phone_number);
    		   stat.setString(8, role);
    		   stat.executeUpdate();
               return true;
    	}
    	return false;
    }
}

