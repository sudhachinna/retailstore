package in.vamsoft.retailstore;

public class Customer {
  int customerID;
  String customerName;
  int contactNumber;
  public int cid = 2;

  public Customer() {
    super();
    // TODO Auto-generated constructor stub
  }

  public void addCustomer(String customerName, int contactNumber) {
    Customer c = new Customer(cid, customerName, contactNumber);

    cid++;

  }

  public Customer(int customerID, String customerName, int contactNumber) {
    super();
    this.customerID = customerID;
    this.customerName = customerName;
    this.contactNumber = contactNumber;
  }

  public int getCustomerID() {
    return customerID;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public int getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(int contactNumber) {
    this.contactNumber = contactNumber;
  }

  @Override
  public String toString() {
    return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", contactNumber=" + contactNumber
        + "]";
  }

}
