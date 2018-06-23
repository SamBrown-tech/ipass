package nl.hu.ipass.gitaarshop.persistence;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import nl.hu.ipass.gitaarshop.model.Product;

public interface PurchaseProductDao {
	
	// Stores purchase in database
	public boolean save(int product_id, int quantity) throws SQLException, ClassNotFoundException;
	
	
	
}
