package in.vamsoft.retailstore;

/* 
 * @project name:Retail store Management.
 * @Date :07-nov-2017
 * @ class name is Product
 */
public class Product {
  int productID;
  String productName;
  int quatity;
  double productPrice;

  
  public static int pid = 1;

 
  /*
   * constructor name is product initializes the values.
   */
  public Product(int productID, String productName, double productPrice,int quatity ) {
    super();
    this.productID = productID;
    this.productName = productName;
    this.quatity = quatity;
    this.productPrice = productPrice;
  }

  public void addProduct(String productName,double productPrice,int quantity) {
    Product c = new Product(pid, productName, productPrice,quantity);
     pid++;

   }
  

  
  public int checkProductAvailability(String productName) {
    
    Product c = new Product(productID, productName, productPrice,quatity);

    return -1;
  }

  public Product() {
    super();
    // TODO Auto-generated constructor stub
  }
  

   /*
   * initializes getter and setter method.
   */
  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getQuatity() {
    return quatity;
  }

  public void setQuatity(int quatity) {
    this.quatity = quatity;
  }

  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }
  
 

}
