package nl.hu.ipass.gitaarshop.model;

import java.sql.SQLException;

import nl.hu.ipass.gitaarshop.persistence.personDaoPostgresImpl;

public class PersonService {
	
	// Inserts a new user in the database
	public boolean newUser(String email, String firstname, String lastname, String password) throws ClassNotFoundException, SQLException{
		personDaoPostgresImpl p1 = new personDaoPostgresImpl();
        p1.newUser(email, firstname, lastname, password);
		return true;
	}
	
	// Returns id of user
	public int findIdOfUser(String email) throws ClassNotFoundException, SQLException{
		personDaoPostgresImpl p1 = new personDaoPostgresImpl();
		return p1.findIdOfUser(email);
	}
}
