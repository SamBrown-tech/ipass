package nl.hu.ipass.gitaarshop.model;

import java.sql.SQLException;

import nl.hu.ipass.gitaarshop.persistence.personDaoPostgresImpl;

public class PersonService {
	
	// Inserts a new user in the database
	public boolean newUser(String email, String firstname, String lastname, String password) throws ClassNotFoundException, SQLException{
		System.out.println("personservice");
		personDaoPostgresImpl c1 = new personDaoPostgresImpl();
        c1.newUser(email, firstname, lastname, password);
		return true;

	}
}
