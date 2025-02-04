import core.data.*;

public class Welcome01 {
   public static void main(String[] args) {

      DataSource ds = DataSource.connect("data.xml"); 
      ds.setCacheTimeout(15 * 60);  
      ds.load();
      ds.printUsageString();
      
   }
}
