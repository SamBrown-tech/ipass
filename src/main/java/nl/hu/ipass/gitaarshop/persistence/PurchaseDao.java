package nl.hu.ipass.gitaarshop.persistence;

import java.sql.SQLException;
import java.util.List;

import nl.hu.ipass.gitaarshop.model.Product;
import nl.hu.ipass.gitaarshop.model.Purchase;

public interface PurchaseDao {
	
	// Returns a list of all purchases
	public List<Purchase> findAll() throws SQLException, ClassNotFoundException;
	
}