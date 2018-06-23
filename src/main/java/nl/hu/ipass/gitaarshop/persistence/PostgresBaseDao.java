package nl.hu.ipass.gitaarshop.persistence;

import java.sql.Connection;

import javax.sql.DataSource;
import javax.naming.InitialContext;

public class PostgresBaseDao {
	protected final Connection getConnection() {
		Connection result = null;

		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/PostgresDS");
			jdbc:postgresql://ec2-54-247-100-44.eu-west-1.compute.amazonaws.com/d8bvhgrnh2f7fm?user=crgdfkpaidnlaa&password=c7ced32e468ddd9c91ade4f26afada2fd2dacd68e6d8798ca08b861734847d86
			result = ds.getConnection();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

		return result;
	}

}