package nl.hu.ipass.gitaarshop.model;

import java.sql.SQLException;
import java.util.List;

import nl.hu.ipass.gitaarshop.persistence.PurchaseProductDaoPostgresImpl;

public class PurchaseProductService {
	
	// Stores purchaseproduct in database
	public boolean save(int product_id, int quantity, int purchase_id) throws ClassNotFoundException, SQLException {
		PurchaseProductDaoPostgresImpl p1 = new PurchaseProductDaoPostgresImpl();
        p1.save(product_id, quantity, purchase_id);
		return true;
	}
}
