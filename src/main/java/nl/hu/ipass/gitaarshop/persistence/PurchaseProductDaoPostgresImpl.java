package nl.hu.ipass.gitaarshop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class PurchaseProductDaoPostgresImpl extends PostgresBaseDao implements PurchaseProductDao {
	
	// Stores a purchaseproduct in database
	public boolean save(int product_id, int quantity) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

            String insert = "INSERT INTO purchaseproduct (purchase_id, product_id, quantity) VALUES(2, ?, ?)";

            PreparedStatement stat = conn.prepareStatement(insert);
            // stat.setInt(1, purchase_id);
            stat.setInt(1, product_id);
            stat.setInt(2, quantity);
            
            stat.executeUpdate();
            return true;
    }
}
