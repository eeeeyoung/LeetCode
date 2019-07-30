import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/most-common-word/.
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> banList = new ArrayList<>();
        for (String s : banned) banList.add(s);
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        paragraph = paragraph.trim();
        paragraph = paragraph + ' ';
        String word = "";
        for (char c : paragraph.toCharArray()) {
            if (c != ' ') {
                word = word + c;
            } else {
                word = word.toLowerCase();
                if (!banList.contains(word)) {
                    treeMap.putIfAbsent(word, 0);
                    treeMap.put(word, treeMap.get(word) + 1);
                }
                word = "";
            }
        }
        String res = "";
        int count = 0;
        for (String key : treeMap.keySet()) {
            if (treeMap.get(key) > count) {
                count = treeMap.get(key);
                res = key;
            }
        }
        return res;
    }
}
