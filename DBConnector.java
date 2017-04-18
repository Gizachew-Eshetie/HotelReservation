/**
 * Created by Gize on 4/17/2017.
 */

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;



public class DBConnector {
    //static reference to itself
    private static DBConnector instance = new DBConnector();
    public static final String URL = "jdbc:mysql://localhost:3306/hotelreservation?useSSL=false";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    //private constructor
    private DBConnector() {
        try {
            //Step 2: Load MySQL Java driver
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {

        Connection connection = null;
        try {
            //Step 3: Establish Java MySQL connection

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }
}

