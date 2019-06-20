import java.util.HashMap;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] hash = new int[256];
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for (char c : cht) {
            hash[c]++;
        }
        int[] res = new int[2];
        int i = 0, j = 0, count = cht.length, minLen = Integer.MAX_VALUE;
        // move outer pointer to the right by one
        while (j < chs.length) {
            char c = chs[j];
            if (hash[c] >= 1) {
                count--;
            }
            hash[c]--;
            j++;
            // adjust back and forth the back pointer
            while (count == 0) {
                if (j - i < minLen) {
                    minLen = j - i;
                    res[0] = i;
                    res[1] = j;
                }
                char prev = chs[i];
                if (hash[prev] >= 0) {
                    count++;
                }
                hash[prev]++;
                i++;
            }
        }
        return s.substring(res[0], res[1]);
    }
}