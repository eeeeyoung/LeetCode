/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/.
 *
 * Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.
 *
 * Note: Here, "make two strings equal" means having a stringA.equals(stringB)
 */
public class MinimumASCIIDeleteSumforTwoStrings {
    /**
     * Just a variant a Global DNA sequence alignment, but with gap penalty equal to the ASCII code of deleted char.
     * @param s1 Input String 1
     * @param s2 Input String 2
     * @return the minimum gap penalty taken
     */
    public int minimumDeleteSum(String s1, String s2) {
        // Init
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] score = new int[l1+1][l2+1];

        // Base case, col 0 and row 0
        score[0][0] = 0;
        for (int i = 1; i <= l1; i++) {
            score[i][0] = score[i - 1][0] - s1.charAt(i - 1);
        }
        for (int i = 1; i <= l2; i++) {
            score[0][i] = score[0][i - 1] - s2.charAt(i - 1);
        }

        // Recursion
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                score[i][j] = maxOfThree(
                        score[i - 1][j] - s1.charAt(i - 1),
                        score[i][j - 1] - s2.charAt(j - 1),
                        score[i - 1][j - 1] - (s1.charAt(i - 1) == s2.charAt(j - 1) ? 0 : 123000));
            }
        }

        return (-1) * score[l1][l2];
    }

    private static Integer maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
