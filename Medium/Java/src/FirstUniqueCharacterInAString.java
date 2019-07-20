import java.util.HashMap;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/.
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.putIfAbsent(c, 0);
            int count = map.get(c);
            map.put(c, count + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))==1) {
                return i;
            }
        }
        return 'a';
    }
}
