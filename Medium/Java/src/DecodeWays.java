import java.util.HashSet;

/**
 * https://leetcode.com/problems/decode-ways/.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null ||  s.equals("")) return 0;
        HashSet<String> ref = new HashSet<>();
        for (int i = 1; i <= 26; i++) {
            ref.add(String.valueOf(i));
        }
        char[] charArray = s.toCharArray();
        int[] res = new int[charArray.length + 1];
        res[0] = 1;
        res[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i < s.length(); i++) {
            char prevChar = s.charAt(i - 1);
            if (s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 1) {
                res[i] += res[i - 1];
            }
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (second >= 10 && second <= 26) {
                res[i] += res[i - 2];
            }
        }

        return res[s.length() - 1];
    }
}
