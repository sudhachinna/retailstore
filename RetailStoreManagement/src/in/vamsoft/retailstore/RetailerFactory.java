package in.vamsoft.retailstore;

import java.io.IOException;
import java.sql.SQLException;

public class RetailerFactory {
  
  public static RetailsDAO getretail()  {
    try {
      return new RetailStore();
    } catch (ClassNotFoundException | SQLException | IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
    
  }

}
