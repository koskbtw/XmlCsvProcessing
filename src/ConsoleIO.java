import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Scanner;

public class ConsoleIO {
    private Scanner scanner;

    public String readPath() throws UnsupportedEncodingException {
        System.out.println("Введите путь для файла: ");
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void outDataXml(ResultXml result) {

        for (Map.Entry<String, Map<Integer, Integer>> cityEntry : result.getCityFloorMap().entrySet()) {
            String city = cityEntry.getKey();
            System.out.println("Город: " + city);

            Map<Integer, Integer> floorMap = cityEntry.getValue();
            for (Map.Entry<Integer, Integer> floorEntry : floorMap.entrySet()) {
                int floor = floorEntry.getKey();
                int count = floorEntry.getValue();
                System.out.println("  Этаж " + floor + ": " + count + " здание(й)");
            }
        }

        // Вывод дублирующихся записей
        System.out.println("\nДублирующиеся записи с количеством повторений:");
        for (Map.Entry<String, Integer> entry : result.getDuplicateMap().entrySet()) {
            int count = entry.getValue();
            if (count > 1) { // Отображаем только дубли
                System.out.println(entry.getKey() + " — " + count + " раз(а)");
            }
        }
    }


    public void displayMessage(String message)
    {
        System.out.println(message);
    }

    public void outDataCsv(ResultCsv result){
        System.out.println("Распределение этажей по городам:");
        result.getCityFloorCount().forEach((city, floors) -> {
            System.out.println("Город: " + city);
            for (int i = 1; i <= 5; i++) { // Перебираем этажи от 1 до 5
                int count = floors.getOrDefault(i, 0);
                System.out.println("  Этаж " + i + ": " + count + " зданий");
            }
        });

        System.out.println("\nДублирующиеся записи:");
        result.getDuplicateCount().forEach((key, count) -> {
            if (count > 1) {
                System.out.println(key + " - повторений: " + count);
            }
        });
    }

    public String readCommand()
    {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void timeProcessed(long startTime, long endTime)
    {
        System.out.println("\nВремя выполнения программы: " + (endTime - startTime) + " мс");
    }




}
