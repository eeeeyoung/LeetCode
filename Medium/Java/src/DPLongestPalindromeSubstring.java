/**
 * https://leetcode.com/problems/longest-palindromic-substring/.
 *
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 */
public class DPLongestPalindromeSubstring {
    /**
     * Attempt to implement expand around center.
     * @param s the input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Corner cases
        if (s == null || s.length() < 1) return "";

        int max = Integer.MIN_VALUE;
        int start = 0, end = 0;
        int l, l1, l2;

        // expands for each center position
        for (int i = 0; i < s.length(); i++) {
            l1 = expandAroundCenter(s, i, i);
            l2 = expandAroundCenter(s, i, i+1);
            l = Math.max(l1, l2);

            if (l > max) {
                max = l;
                start = i - (l - 1) / 2; // - 1 no use
                end = i + l / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int Left, int Right) {
        int R = Right;
        int L = Left;

        while (L >= 0 && R <= s.length() - 1 && (s.charAt(L) == s.charAt(R))) {
            R++;
            L--;
        }

        return R - L + 1 - 2; // The while loop executes for another round, -2.
    }
}
