package in.vamsoft.retailstore;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcDaoConnection {

  static Connection con;

  public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
    FileReader reader = new FileReader("/home/vamsoft/Desktop/db.properties");
    Properties prop = new Properties();
    prop.load(reader);
    String driver = prop.getProperty("driver");
    String url = prop.getProperty("url");
    String username = prop.getProperty("username");
    String password = prop.getProperty("password");
    Class.forName(driver);
    con = DriverManager.getConnection(url, username, password);
    return con;

  }

  public static boolean closeConnection() throws SQLException {
    con.close();

    return true;

  }

}
