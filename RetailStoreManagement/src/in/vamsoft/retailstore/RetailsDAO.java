package in.vamsoft.retailstore;

import java.sql.SQLException;

/*
 * @project name is RetailStore Management.
 * @Interface name is RetailsDAO.
 * @passing some methods.
 */
public interface RetailsDAO {

  public boolean addCustomer(String name, int contactNo);

  public boolean addProduct(String pname, double price, int pquantity);

  public int checkProductAvailability(String productName);

  public int bookProduct(int customerID, String ProductName, int qtyOfProduct) throws SQLException;

  public double calculateNetAmount(int customerID, double Discount);

}
