import java.awt.Color;
import java.io.File;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;


public class BestGameFinder {
    public static void main(String[] args) {
        try {
            
            File xmlFile = new File("data.xml");
            

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("record");
            //String bestGame = "";
            //double highestSales = 0.0;
            double[] numBuyers = new double[10]; 
            String[] gameName = new String[10];

            for (int i = 0; i < 10; i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    //int yearReleased = Integer.parseInt(element.getElementsByTagName("Year").item(0).getTextContent());
                    gameName[i] =  element.getElementsByTagName("Name").item(0).getTextContent();
                    numBuyers[i] = Double.parseDouble(element.getElementsByTagName("Global_Sales").item(0).getTextContent());
                }
            }

            JFrame frame = new JFrame("Video Games based on Global Sales");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            BarGraph graph = new BarGraph(numBuyers, gameName, Color.BLUE);
            frame.add(graph);
            frame.setVisible(true);

            //System.out.println("The best game based on global sales is: " + bestGame + " with " + highestSales + " million sales.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
