package org.costaff.util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
    This class is used to obtain the connection
    // Singleton pattern
* */
public class ConnectionUtils {
    private static Connection connection = null;
    private ConnectionUtils() {

    }
    static {
        try {
        	InputStream is = ConnectionUtils.class.getClassLoader().getResourceAsStream(Constants.DB_PROPS_FILE);            
            // We are creating the object for properties class
            Properties properties = new Properties();
            properties.load(is);
            // We are accessing property value by key
            String driver = properties.getProperty(Constants.DRIVER);
            String url = properties.getProperty(Constants.URL);
            String username = properties.getProperty(Constants.USERNAME);
            String password = properties.getProperty(Constants.PASSWORD);           

           
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Exception occurred" + e);
        }
    }
    public static Connection getConnection() {
        return connection;
    }
}
