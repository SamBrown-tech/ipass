package nl.hu.ipass.gitaarshop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Eigenaar
 *
 */
public class personDaoPostgresImpl extends PostgresBaseDao implements personDao {

    /* (non-Javadoc)
     * @see nl.hu.ipass.gitaarshop.persistence.personDAO#findRoleForUser(java.lang.String, java.lang.String)
     */
    @Override
    // Returns role of user
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
    
    // Inserts a new user in the database    
    public boolean newUser(String email, String firstname, String lastname, String password) throws ClassNotFoundException, SQLException {
    	Connection con = super.getConnection();
    	String query = ("INSERT INTO person (email, firstname, lastname, password, role)\r\n" + 
    			"VALUES (?, ?, ?, ?, 'klant')");
    	
    	String query2 = ("INSERT INTO purchase (purchase_id, person_id, date)\r\n" + 
    			"VALUES ((SELECT person_id FROM person WHERE email = ?), (SELECT person_id FROM person WHERE email = ?), current_timestamp)");
	    PreparedStatement stat = con.prepareStatement(query);
	    PreparedStatement stat2 = con.prepareStatement(query2);
	    stat.setString(1, email);
	    stat.setString(2, firstname);
	    stat.setString(3, lastname);
	    stat.setString(4, password);
	    stat.executeUpdate();
	    stat2.setString(1, email);
	    stat2.setString(2, email);
	    stat2.executeUpdate();
	    
        return true;
    }
    
}

