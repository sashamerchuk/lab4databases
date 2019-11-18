package controller.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection get_connection(){
        String url = "jdbc:mysql://localhost:3306/hospitallab4db?serverTimezone=Europe/Kiev";
        String user = "root";
        String password  = "sashamerchukqwerty12";
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connect to database succesfully!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
