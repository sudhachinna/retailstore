package in.vamsoft.retailstore;

import java.io.IOException;
import java.sql.SQLException;

public class RetailerFactory {
  
  public static RetailsDAO getretail() throws ClassNotFoundException, SQLException, IOException {
    return new RetailStore();
    
  }

}
