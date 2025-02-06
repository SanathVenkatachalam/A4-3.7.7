import core.data.*;

public class Welcome01 {
   public static void main(String[] args) {

      DataSource ds = DataSource.connect("data.xml"); 
      //DataSource NaSales = DataSource.connect("data.xml" + "NA_Sales");
      ds.load();
      ds.printUsageString();
      //ds.help();


      System.out.println(ds.getDataAccess());
      
      
      
      
   }
}
