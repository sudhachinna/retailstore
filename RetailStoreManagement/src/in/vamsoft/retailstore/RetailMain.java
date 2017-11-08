package in.vamsoft.retailstore;

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

      System.out.println("1.addcustomer\n2.addproduct\n3.checkProduct\n 4.bookproduct");
      System.out.println("Enter your choice");
      Scanner scan1 = new Scanner(System.in);
      c = scan1.nextInt();

      switch (c) {
        case 1: {
          System.out.println("Please Enter the Customer Name : ");
          String name = scan.next();
          System.out.println("Please Enter the Contact No: ");
          int contactno = scan1.nextInt();

          Customer cus = new Customer(i, name, contactno);

          RetailsDAO dao = RetailerFactory.getretail();
          dao.addCustomer(name, contactno);
          break;
        }
        case 2: {
          System.out.println("Please Enter the Product Name : ");
          String pname = scan.next();
          System.out.println("Please Enter the Product Price: ");
          price = scan1.nextDouble();
          System.out.println("Please Enter the Product Quantity: ");
          pquantity = scan1.nextInt();

          Product product = new Product(i, pname, price, pquantity);

          RetailsDAO dao = RetailerFactory.getretail();
          dao.addProduct(pname, price, pquantity);
          break;
        }
        case 3: {
          System.out.println("Please Enter the Product Name : ");
          String pname = scan.next();

          Product product = new Product(i, pname, price, pquantity);

          RetailsDAO dao = RetailerFactory.getretail();
          System.out.println(dao.checkProductAvailability(pname));

          break;
        }
        case 4: {
          System.out.println("Please Enter the Product Name : ");

          String pname = scan.next();
          System.out.println("Please Enter the Quantity : ");
          pquantity = scan1.nextInt();
          System.out.println("Please Enter the Customer id : ");
          int c_id = scan1.nextInt();
          Product product = new Product(i, pname, price, pquantity);

          RetailStore obj = new RetailStore();
          obj.bookProduct(c_id, pname, pquantity);

          RetailsDAO dao = RetailerFactory.getretail();
          System.out.println(dao.checkProductAvailability(pname));

        }
        default: {
          System.out.println("Please Select valid Option");
        }
      }
    } while (c < 5);

  }

}
