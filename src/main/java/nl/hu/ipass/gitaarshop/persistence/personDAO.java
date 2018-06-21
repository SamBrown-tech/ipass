package nl.hu.ipass.gitaarshop.persistence;

import java.sql.SQLException;

public interface personDAO {
	public String findRoleForUser(String email, String pass) throws SQLException, ClassNotFoundException;
	
	public boolean newUser(String email, String firstname, String lastname, String city, String zip_code,
			String password, String phone_number, String role) throws ClassNotFoundException, SQLException;
}
