import java.util.HashMap;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/time-based-key-value-store/.
 */
public class TimeBasedKeyValueStore {

    private HashMap<String, TreeMap<Integer, String>> TimeMap;
    /** Initialize your data structure here. */
    public TimeBasedKeyValueStore() {
        TimeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!TimeMap.containsKey(key)) TimeMap.put(key, new TreeMap<>());
        TimeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!TimeMap.containsKey(key)) return "";
        Integer theKey = TimeMap.get(key).floorKey(timestamp);
        return theKey != null ? TimeMap.get(key).get(timestamp) : "";
    }
}
