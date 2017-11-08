package in.vamsoft.retailstore;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

  public int cid = 2;

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

  public static int pid = 2;

  public void addProduct(String productName, double productPrice, int quantity) {
    try (PreparedStatement statement = con.prepareStatement("insert into product values(?,?,?,?)");) {
      statement.setInt(1, pid++);
      statement.setString(2, productName);
      statement.setDouble(3, productPrice);
      statement.setInt(4, quantity);

      int rowsUpdated = statement.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();

    }

  }

  public int checkProductAvailability(String productName) {
    try (PreparedStatement pst = con.prepareStatement("select * from product where p_name=?");) {
      pst.setString(1, productName);
      rs = pst.executeQuery();

      int avaiable = 0;
      if (rs.next()) {

        avaiable = rs.getInt(4);

      } else {
        throw new Exception("Product with code" + productName + "not found");
      }
      return avaiable;

    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;

  }

  public int bookProduct(int customerID, String ProductName, int qtyOfProduct) throws SQLException {

    int updateQuantity;
    System.out.println("RetailStore.bookProduct()");
    int available = checkProductAvailability(ProductName);
    System.out.println("Check Condition Excuted");
    if (available >= qtyOfProduct) {
      System.out.println("The Product Booked");
      updateQuantity = available - qtyOfProduct;
      PreparedStatement statement = con.prepareStatement("update product set qty=? where p_name=?");
      System.out.println("create statement executed");

      statement.setInt(1, updateQuantity);
      statement.setString(2, ProductName);
      int latestUpdate = statement.executeUpdate();
      PreparedStatement statement2 = con.prepareStatement("select * from product where p_name=?");
      statement2.setString(1, ProductName);
      int price = 0;
      int pid = 0;
      double total = 0;
      rs=statement2.executeQuery();
      while(rs.next()) {
        pid = rs.getInt(1);
        price = rs.getInt(3);
        total = qtyOfProduct * price;
      }

      if (latestUpdate > 0) {
        System.out.println("Database quantity is Updated");
        int inv_id = 1;
        
        try (PreparedStatement statement1 = con.prepareStatement("insert into productinvoice values(?,?,?,?,?,?)");) {
          statement1.setInt(1, inv_id++);
          statement1.setInt(2, pid);
          statement1.setString(3, ProductName);
          statement1.setDouble(4, qtyOfProduct);
          statement1.setInt(5, price);
          statement1.setDouble(6, total);

          int rowsUpdated = statement1.executeUpdate();

        } catch (SQLException e) {
          e.printStackTrace();

        }

      } else {
        System.out.println("The quantity is not updated");
      }

    } else {
      System.out.println("The Product is Not Available");
    }
    return available;

  }

  public double calculateNetAmount(int customerID, double Discount) {
    return -1;
  }

  @Override
  public void close() throws Exception {
    // TODO Auto-generated method stub

  }

}
