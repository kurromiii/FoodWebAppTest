package ir.foodwebapp.model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//192.168.146.239

public class ConnectionProvider {
    private static ConnectionProvider connectionProvider = new ConnectionProvider();

    private ConnectionProvider() {
    }

    public static ConnectionProvider getConnectionProvider(){
       return connectionProvider;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "project", "javase");
    }
}
