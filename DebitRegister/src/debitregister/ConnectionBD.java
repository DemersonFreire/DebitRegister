package debitregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
    
    public static Connection getConnection(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://database-1.cc2qow3tse8e.us-east-1.rds.amazonaws.com:5432/postgres","NomeBanco","SenhaBanco");
            
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}