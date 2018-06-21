package nl.hu.ipass.gitaarshop.model;

import java.sql.SQLException;

import nl.hu.ipass.gitaarshop.persistence.personPostgresDAOImpl;

public class PersonService {
	public boolean newUser(String email, String firstname, String lastname, String city, String zip_code,
			String password, String phone_number, String role) throws ClassNotFoundException, SQLException{
		personPostgresDAOImpl c1 = new personPostgresDAOImpl();
        c1.newUser(email, firstname, lastname, city, zip_code, password, phone_number, role);
		return true;

	}
}
