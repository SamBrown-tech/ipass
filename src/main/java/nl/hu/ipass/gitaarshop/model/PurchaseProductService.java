package nl.hu.ipass.gitaarshop.model;

import java.sql.SQLException;
import java.util.List;

import nl.hu.ipass.gitaarshop.persistence.PurchaseProductDaoPostgresImpl;

public class PurchaseProductService {
	
	public boolean save(int product_id, int quantity) throws ClassNotFoundException, SQLException {
		PurchaseProductDaoPostgresImpl p1 = new PurchaseProductDaoPostgresImpl();
        p1.save(product_id, quantity);
		return true;
	}
}
