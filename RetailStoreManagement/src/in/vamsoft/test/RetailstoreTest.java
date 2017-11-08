package in.vamsoft.test;
/*
 * @project name:RetailStore Management.
 * @test the customer,testcheckProductAvailability and product.
 */
import static org.junit.Assert.*;

import org.junit.Test;

import in.vamsoft.retailstore.Product;
import in.vamsoft.retailstore.RetailerFactory;
import in.vamsoft.retailstore.RetailsDAO;

public class RetailstoreTest {

  RetailsDAO dao = RetailerFactory.getretail();

  public void testaddCustomer() {
    
    boolean actual=dao.addCustomer("sudha", 741258);
    assertTrue(actual);
  }

  @Test
  public void testAddProduct() {
    //Product product = new Product(1, "mobile", 1000,100);
    boolean actual=dao.addProduct("mobile", 1000, 20);
    assertTrue(actual);
  }
  
  @Test
  public void testcheckProductAvailability() {
    //Product product = new Product(1, "mobile", 1000,100);
    int actual=dao.checkProductAvailability("Tv");
    assertEquals(16, actual);
  }
  

}
