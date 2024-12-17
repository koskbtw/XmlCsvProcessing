import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;



public class XmlProcessor {
    public  ResultXml Process(String path) {
        try {

            File xmlFile = new File(path);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("item");
            Map<String, Map<Integer, Integer>> cityFloorMap = new HashMap<>();
            Map<String, Integer> duplicateMap = new HashMap<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String city = element.getAttribute("city");
                    String street = element.getAttribute("street");
                    String house = element.getAttribute("house");
                    int floor = Integer.parseInt(element.getAttribute("floor"));
                    String duplicateKey = String.format("%s, %s, %s, %d", city, street, house, floor);
                    duplicateMap.put(duplicateKey, duplicateMap.getOrDefault(duplicateKey, 0) + 1);
                    cityFloorMap.putIfAbsent(city, new HashMap<>());
                    Map<Integer, Integer> floorMap = cityFloorMap.get(city);
                    floorMap.put(floor, floorMap.getOrDefault(floor, 0) + 1);
                }
            }
            return new ResultXml(cityFloorMap, duplicateMap);


        } catch (Exception e) {
            System.err.println("Ошибка: Не удалось обработать файл '" + path + ".");
            System.err.println("Так как: " + e.getMessage());
            e.printStackTrace();
            return null;
        }


    }

}
