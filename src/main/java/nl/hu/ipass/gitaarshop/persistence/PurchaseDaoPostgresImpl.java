package nl.hu.ipass.gitaarshop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.ipass.gitaarshop.model.Purchase;


public class PurchaseDaoPostgresImpl extends PostgresBaseDao implements PurchaseDao  {
	public List<Purchase> findAll() throws SQLException, ClassNotFoundException {
		ArrayList<Purchase> list_purchases = new ArrayList<Purchase>();
		Connection conn = getConnection();

		String query = "SELECT pr.name, pr.price, pp.quantity, p.email, p.person_id\r\n"
				+ "from product pr, purchaseproduct pp, purchase pu, person p\r\n"
				+ "where pr.product_id = pp.product_id AND pp.purchase_id = pu.purchase_id and p.person_id = pu.person_id";
		PreparedStatement stat = conn.prepareStatement(query);
		ResultSet rs = stat.executeQuery();

		while (rs.next()) {
			Purchase purchase = new Purchase();
			purchase.setName(rs.getString("name"));
			purchase.setQuantity(rs.getInt("quantity"));
			purchase.setPrice(rs.getDouble("price"));
			purchase.setEmail(rs.getString("email"));
			list_purchases.add(purchase);
		}

		return list_purchases;
	}

	public List<Purchase> getAllProducten() throws SQLException, ClassNotFoundException {
		PurchaseDaoPostgresImpl p1 = new PurchaseDaoPostgresImpl();
		p1.findAll();
		return p1.findAll();
	}
}
