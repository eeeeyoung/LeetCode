import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/.
 */
public class LetterCombinationsOfAPhoneNumber {

    private static HashMap<Integer, List<Character>> mapping;

    public List<String> letterCombinations(String digits) {
        mapping = new HashMap<>();
        initMap();
        List<String> res = new ArrayList<>();
        if (digits == null || digits.equals("")) return res;
        backtrack(res, digits, 0, "");
        return res;
    }

    private void backtrack(List<String> res, String digits,
                           int pos, String curString) {
        int num;
        if (pos < digits.length()) {
            num = digits.charAt(pos) - 48;
            for (Character c : mapping.get(num)) {
                String tmp = curString + c;
                backtrack(res, digits, pos + 1, tmp);
            }
        } else {
            res.add(curString);
            return;
        }
    }

    private void initMap() {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('c');
        mapping.put(2, list);
        list = new ArrayList<>();
        list.add('d');
        list.add('e');
        list.add('f');
        mapping.put(3, list);
        list = new ArrayList<>();
        list.add('g');
        list.add('h');
        list.add('i');
        mapping.put(4, list);
        list = new ArrayList<>();
        list.add('j');
        list.add('k');
        list.add('l');
        mapping.put(5, list);
        list = new ArrayList<>();
        list.add('m');
        list.add('n');
        list.add('o');
        mapping.put(6, list);
        list = new ArrayList<>();
        list.add('p');
        list.add('q');
        list.add('r');
        list.add('s');
        mapping.put(7, list);
        list = new ArrayList<>();
        list.add('t');
        list.add('u');
        list.add('v');
        mapping.put(8, list);
        list = new ArrayList<>();
        list.add('w');
        list.add('x');
        list.add('y');
        list.add('z');
        mapping.put(9, list);
    }
}
