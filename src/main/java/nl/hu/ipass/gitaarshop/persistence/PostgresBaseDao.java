package nl.hu.ipass.gitaarshop.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresBaseDao{
    private static Connection conn;
    protected final Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection("jdbc:postgresql://ec2-54-247-100-44.eu-west-1.compute.amazonaws.com/d8bvhgrnh2f7fm?user=crgdfkpaidnlaa&password=c7ced32e468ddd9c91ade4f26afada2fd2dacd68e6d8798ca08b861734847d86");

        return conn;

    }

}