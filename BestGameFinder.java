
import java.io.File;
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
            String bestGame = "";
            double highestSales = 0.0;

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String name = element.getElementsByTagName("Name").item(0).getTextContent();
                    double globalSales = Double.parseDouble(element.getElementsByTagName("Global_Sales").item(0).getTextContent());

                    if (globalSales > highestSales) {
                        highestSales = globalSales;
                        bestGame = name;
                    }
                }
            }
            System.out.println("The best game based on global sales is: " + bestGame + " with " + highestSales + " million sales.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
