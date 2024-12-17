import java.io.File;
import java.io.UnsupportedEncodingException;

/*
 * Консольная программа для обработки XML и CSV файлов.
 *
 * @author Платонов Владислав 3353
 * @author Коновалов Максим 3353
 *
 */


public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {


        ConsoleIO console = new ConsoleIO();
        long startTime = System.currentTimeMillis();
        String filePath = console.readPath();

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.err.println("Error: File not found or invalid path.");
            System.exit(1);
        }
        if (filePath.endsWith(".xml")) {
            XmlProcessor Xml = new XmlProcessor();
            ResultXml resultXml;
            resultXml = Xml.Process(filePath);
            console.displayMessage("Количество зданий по городам и этажам:");
            console.outDataXml(resultXml);
            long endTime = System.currentTimeMillis();
            console.timeProcessed(startTime, endTime);

        } else if (filePath.endsWith(".csv")) {
            CsvProcessor Csv = new CsvProcessor();
            ResultCsv resultCsv;
            resultCsv = Csv.Process(filePath);
            console.displayMessage("Количество зданий по городам и этажам:");
            console.outDataCsv(resultCsv);
            long endTime = System.currentTimeMillis();
            console.timeProcessed(startTime, endTime);

        } else {
            console.displayMessage("Ошибка: Неподдерживаемый тип файла. Поддерживаются только файлы .xml и .csv ");
            System.exit(1);
        }

        console.displayMessage("Введите 'exit' для завершения работы приложения:");
        String command = console.readCommand();
        if ("exit".equalsIgnoreCase(command))
        {
            console.displayMessage("Завершаю работу программы...");
            System.exit(0);
        }
    }
}



