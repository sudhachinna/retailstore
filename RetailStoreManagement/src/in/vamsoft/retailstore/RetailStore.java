package in.vamsoft.retailstore;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.io.IOException;

public class RetailStore implements RetailsDAO, AutoCloseable {
  String storeName;

  Connection con;
  PreparedStatement statement;
  ResultSet rs;

  public RetailStore() throws ClassNotFoundException, SQLException, IOException {

    con = JdbcDaoConnection.getConnection();
  }

  public RetailStore(String storeName) {
    super();
    this.storeName = storeName;
  }
  public static int cid=1;

  public void addCustomer(String name, int contactNo) {

    try (PreparedStatement statement = con.prepareStatement("insert into customer10 values(?,?,?)");) {
      statement.setInt(1, cid++);
      statement.setString(2, name);
      statement.setInt(3, contactNo);

      int rowsUpdated = statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();

    }

  }
  
  public static int pid=1;
  
  public void addProduct(String name,String status,double price,long quantity) {
    try (PreparedStatement statement = con.prepareStatement("insert into product values(?,?,?,?)");) {
      statement.setInt(1, pid++);
      statement.setString(2, name);
      statement.setString(3, status);
      statement.setDouble(4, price);
      statement.setLong(5, quantity);

      int rowsUpdated = statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();

    }

  }
  

  public int checkProductAvailability(String productName) {
    try (PreparedStatement pst = con.prepareStatement("select * from empcopy where empid=?");) {
      pst.setString(1, productName);
      rs = pst.executeQuery();
      Product pdct = null;
      
      if (rs.next()) {
        pdct = new Product();
        pdct.setQuatity(rs.getInt(4));

      
      } else {
        throw new Exception("Product with code" + productName + "not found");
      }
     
    }catch(Exception e) {
      e.printStackTrace();
    }
    return 0;
    
  }

  public int bookProduct(int customerID, String ProductName, int qtyOfProduct) {

   return 1;
  }

  public double calculateNetAmount(int customerID, double Discount) {
    return -1;
  }

  @Override
  public void close() throws Exception {
    // TODO Auto-generated method stub

  }
}
