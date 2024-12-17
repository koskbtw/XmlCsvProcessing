import java.util.HashMap;
import java.util.Map;

public class ResultCsv {
    private final HashMap<String, HashMap<Integer, Integer>> cityFloorCount;
    private final HashMap<String, Integer> duplicateCount;

    public ResultCsv(HashMap<String, HashMap<Integer, Integer>> cityFloorCount, HashMap<String, Integer> duplicateCount){
        this.cityFloorCount = cityFloorCount;
        this.duplicateCount = duplicateCount;
    }

    public HashMap<String, HashMap<Integer, Integer>>getCityFloorCount()
    {
        return cityFloorCount;
    }

    public HashMap<String, Integer> getDuplicateCount()
    {
        return duplicateCount;
    }

}
