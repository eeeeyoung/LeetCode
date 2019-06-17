import java.util.List;

/**
 * Word Break.
 * https://leetcode.com/problems/word-break/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 */
public class DPWordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        // init
        boolean[] dp = new boolean[s.length() + 1];

        // base case
        dp[0] = true;

        // recursion
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
                dp[i] = false;
            }
        }

        return dp[s.length()];
    }
}
