package nl.hu.ipass.gitaarshop.persistence;

import java.sql.SQLException;
import java.util.List;

import nl.hu.ipass.gitaarshop.model.Product;

public interface ProductDao {
	
	// Returns a list of all products
	public List<Product> findAll() throws SQLException, ClassNotFoundException;
	
	// Stores product in database
	public boolean save(String name, String description, String image, int price) throws SQLException, ClassNotFoundException;
	
	// Updates product in database
	public boolean update(int id, String name, String description, String image, int price) throws SQLException, ClassNotFoundException;
	
	// Delete product from database
	public boolean delete(String naam) throws SQLException, ClassNotFoundException;
	
}
