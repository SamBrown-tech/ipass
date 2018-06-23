package nl.hu.ipass.gitaarshop.model;

import java.sql.SQLException;
import java.util.List;

import nl.hu.ipass.gitaarshop.persistence.ProductDaoPostgresImpl;

public class ProductService {
	
	// Returns a list of all products
	public List<Product> findAll() throws ClassNotFoundException, SQLException {
		ProductDaoPostgresImpl p1 = new ProductDaoPostgresImpl();
		return p1.findAll();
	}
	
	// Stores product in database
	public boolean save(String name, String description, String image, int price) throws ClassNotFoundException, SQLException {
		ProductDaoPostgresImpl p1 = new ProductDaoPostgresImpl();
        p1.save(name, description, image, price);
		return true;
	}
	
	// Updates product in database
	public boolean update(int id, String name, String description, String image, int price) throws ClassNotFoundException, SQLException {
		ProductDaoPostgresImpl p1 = new ProductDaoPostgresImpl();
        p1.update(id, name, description, image, price);

        return true;
	}

	// Delete product from database
	public boolean delete(String naam) throws  ClassNotFoundException, SQLException {
		ProductDaoPostgresImpl p1 = new ProductDaoPostgresImpl();
		p1.delete(naam);
		
		return true; 
	}
}
