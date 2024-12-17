import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class CsvProcessor {
    public ResultCsv Process (String path) {
        long startTime = System.currentTimeMillis();
        HashMap<String, HashMap<Integer, Integer>> cityFloorCount = new HashMap<>();
        HashMap<String, Integer> duplicateCount = new HashMap<>();

        String csvFile = path;
        String line;
        String delimiter = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                String city = values[0].replace("\"", ""); // Город
                String street = values[1].replace("\"", ""); // Улица
                int house = Integer.parseInt(values[2].replace("\"", ""));
                int floor = Integer.parseInt(values[3].replace("\"", ""));
                String uniqueKey = city + ";" + street + ";" + house + ";" + floor;
                duplicateCount.put(uniqueKey, duplicateCount.getOrDefault(uniqueKey, 0) + 1);
                cityFloorCount.putIfAbsent(city, new HashMap<>());
                HashMap<Integer, Integer> floorCount = cityFloorCount.get(city);
                floorCount.put(floor, floorCount.getOrDefault(floor, 0) + 1);
            }
            return new ResultCsv(cityFloorCount, duplicateCount);
        } catch (Exception e) {
            System.err.println("Ошибка: Не удалось обработать файл '" + path + ".");
            System.err.println("Так как: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

    }
}
