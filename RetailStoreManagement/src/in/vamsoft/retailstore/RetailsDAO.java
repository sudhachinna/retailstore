package in.vamsoft.retailstore;

import java.sql.SQLException;

public interface RetailsDAO {

  public void addCustomer(String name, int contactNo);
  
  public void addProduct(String name,String status,double price,long quantity);

  public int checkProductAvailability(String productName);

  public int bookProduct(int customerID, String ProductName, int qtyOfProduct);

  public double calculateNetAmount(int customerID, double Discount);

}
