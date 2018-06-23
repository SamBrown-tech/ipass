package nl.hu.ipass.gitaarshop.model;

import java.sql.SQLException;
import java.util.List;

import nl.hu.ipass.gitaarshop.persistence.PurchaseDaoPostgresImpl;

public class PurchaseService {
	
	// Returns list of purchases
	public List<Purchase> findAll() throws ClassNotFoundException, SQLException {
		PurchaseDaoPostgresImpl p1 = new PurchaseDaoPostgresImpl();
		return p1.findAll();
	}
	
}
