import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        String tmp;
        for (String word : strs) {
            char[] carray = word.toCharArray();
            Arrays.sort(carray);
            tmp = String.valueOf(carray);
            List<String> tempList = map.getOrDefault(tmp, new ArrayList<>());
            tempList.add(word);
            map.put(tmp, tempList);
        }
        return new ArrayList<>(map.values());
    }
}
