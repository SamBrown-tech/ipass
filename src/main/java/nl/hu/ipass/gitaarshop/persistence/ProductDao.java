package nl.hu.ipass.gitaarshop.persistence;

import java.sql.SQLException;
import java.util.List;

import nl.hu.ipass.gitaarshop.model.Product;

public interface ProductDao {
	
	public List<Product> findAll() throws SQLException, ClassNotFoundException;
	
	public boolean save(String name, String description, String image, int price) throws SQLException, ClassNotFoundException;
	
	public boolean update(int id, String name, String description, String image, int price) throws SQLException, ClassNotFoundException;
	
	public boolean delete(String naam) throws SQLException, ClassNotFoundException;
	
	
}
