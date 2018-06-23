package nl.hu.ipass.gitaarshop.persistence;

import java.sql.SQLException;

public interface personDao {
	
	// Returns role of user
	public String findRoleForUser(String email, String pass) throws SQLException, ClassNotFoundException;

	// Inserts a new user in the database
	public boolean newUser(String email, String firstname, String lastname, String password) throws ClassNotFoundException, SQLException;
}