package in.vamsoft.retailstore;

/*
 *@Project name:RetailStore Management.
 *@RetailMain is Main class of the project.
 *@do,switch case,while is used. 
 */
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RetailMain {

  public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

    Scanner scan = new Scanner(System.in);
    int i = 0;
    double price = 0.0;
    int pquantity = 0;
    String choice;
    int c;
    do {

      System.out.println("1.addcustomer\n2.addproduct\n3.checkProduct\n4.bookproduct");
      System.out.println("Enter your choice:\n");
      Scanner scan1 = new Scanner(System.in);
      c = scan1.nextInt();

      /*
       * @switch case is used to perform some operations.
       * @
       */
      switch (c) {
        case 1: {
          System.out.println("Please Enter the Customer Name : \n");
          String name = scan.next();
          System.out.println("Please Enter the Contact No:\n ");
          int contactno = scan1.nextInt();

          Customer cus = new Customer(i, name, contactno);

          RetailsDAO dao = RetailerFactory.getretail();
          dao.addCustomer(name, contactno);
          System.out.println("Successfuly customer Added\n");
          break;
        }
        case 2: {
          System.out.println("Please Enter the Product Name :\n ");
          String pname = scan.next();
          System.out.println("Please Enter the Product Price: \n");
          price = scan1.nextDouble();
          System.out.println("Please Enter the Product Quantity:\n ");
          pquantity = scan1.nextInt();

          Product product = new Product(i, pname, price, pquantity);

          RetailsDAO dao = RetailerFactory.getretail();
          dao.addProduct(pname, price, pquantity);
          System.out.println("successfuly Product Added\n");
        
          break;
        }
        case 3: {
          System.out.println("Please Enter the Product Name : \n");
          String pname = scan.next();

          Product product = new Product(i, pname, price, pquantity);
          RetailsDAO dao = RetailerFactory.getretail();
          System.out.println("Available Quantity is:\n");
          System.out.println(dao.checkProductAvailability(pname));
          

          break;
        }
        case 4: {
          System.out.println("Please Enter the Product Name :\n ");

          String pname = scan.next();
          System.out.println("Please Enter the Quantity : \n");
          pquantity = scan1.nextInt();
          System.out.println("Please Enter the Customer Id :\n ");
          int c_id = scan1.nextInt();
          Product product = new Product(i, pname, price, pquantity);

          RetailStore obj = new RetailStore();
          obj.bookProduct(c_id, pname, pquantity);

          RetailsDAO dao = RetailerFactory.getretail();
          System.out.println("Bill Generated\n");
       

        }
        default: {
          System.out.println("Please Enter valid Option");
        }
      }
    } while (c < 5);

  }

}
