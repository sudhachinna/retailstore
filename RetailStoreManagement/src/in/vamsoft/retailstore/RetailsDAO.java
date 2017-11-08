package in.vamsoft.retailstore;

import java.sql.SQLException;

public interface RetailsDAO {

  public void addCustomer(String name, int contactNo);

  public void addProduct(String pname, double price, int pquantity);

  public int checkProductAvailability(String productName);

  public int bookProduct(int customerID, String ProductName, int qtyOfProduct) throws SQLException;

  public double calculateNetAmount(int customerID, double Discount);

}
