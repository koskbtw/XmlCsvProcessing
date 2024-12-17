import java.util.Map;

public class ResultXml {
    private final Map<String, Map<Integer, Integer>> cityFloorMap;
    private final Map<String, Integer> duplicateMap;

    public ResultXml(Map<String, Map<Integer, Integer>> cityFloorMap, Map<String, Integer> duplicateMap) {
        this.cityFloorMap = cityFloorMap;
        this.duplicateMap = duplicateMap;
    }

    public Map<String, Map<Integer, Integer>> getCityFloorMap() {
        return cityFloorMap;
    }

    public Map<String, Integer> getDuplicateMap() {
        return duplicateMap;
    }

}
