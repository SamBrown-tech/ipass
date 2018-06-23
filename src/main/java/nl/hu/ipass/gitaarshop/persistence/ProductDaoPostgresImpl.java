package nl.hu.ipass.gitaarshop.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nl.hu.ipass.gitaarshop.model.Product;

public class ProductDaoPostgresImpl extends PostgresBaseDao implements ProductDao {

	@Override
	// Returns a list of all products
	public List<Product> findAll() throws SQLException, ClassNotFoundException {
		ArrayList<Product> list_products = new ArrayList<Product>();
		Connection conn = getConnection();
		
		String query = "SELECT * FROM product";
		PreparedStatement pstmt = conn.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Product product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setName(rs.getString("name"));
			product.setDescription(rs.getString("description"));
			product.setImage(rs.getString("image"));
			product.setPrice(rs.getDouble("price"));
			list_products.add(product);
		}	
		return list_products;
    }
	
	// Stores product in database
	public boolean save(String name, String description, String image, int price) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        if(name != null) {
            String insert = "INSERT INTO product (name, description, image, price) VALUES(?, ?, ?, ?)";

            PreparedStatement stat = conn.prepareStatement(insert);
            stat.setString(1, name);
            stat.setString(2, description);
            stat.setString(3, image);
            stat.setInt(4, price);
            
            stat.executeUpdate();
            return true;
        }
        return false;
    }
	
	// Updates product in database
	public boolean update(int id, String name, String description, String image, int price) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        if (name != null) {
            String query = "UPDATE product SET name = ?, description = ?, image = ?, price = ? WHERE product_id = ?";
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setString(1, name);
            stat.setString(2, description);
            stat.setString(3, image);
            stat.setDouble(4, price);
            stat.setInt(5, id);
            stat.executeUpdate();
            return true;
        }
        return false;
    }
	
	// Delete product from database
	public boolean delete(String naam) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();

        if(naam != null) {
            String insert = "DELETE FROM product WHERE name = ?";

            PreparedStatement stat = conn.prepareStatement(insert);
            stat.setString(1, naam);
            stat.executeUpdate();
            return true;
        }
        return false;
    }
}
