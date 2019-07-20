import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reorganize-string/.
 */
public class ReorganizeString {
    /**
     * Given a string S, check if the letters can be rearranged so that
     * two characters that are adjacent to each other are not the same.
     *
     * If possible, output any possible result.
     * If not possible, return the empty string.
     *
     * @param S input string
     * @return output string
     */
    public String reorganizeString(String S) {
        int alphabetSize = 26;
        int strlen = S.length();
        int[] count = new int[alphabetSize];
        for (char i : S.toCharArray()) {
            count[i - 'a']++;
        }
        PriorityQueue<charCount> pq = new PriorityQueue<>((a, b) ->
                a.count == b.count ? a.ch - b.ch : a.count - b.count);
        for (int i = 0; i < alphabetSize; i++) {
            if (count[i] > (strlen + 1) / 2) {
                return "";
            } else {
                if (count[i] > 0) pq.offer(new charCount((char)('a' + i), count[i]));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (pq.size() >= 2) {
            charCount first = pq.poll();
            charCount second = pq.poll();
            ans.append(first.ch);
            ans.append(second.ch);
            if (--first.count > 0) pq.offer(first);
            if (--second.count > 0) pq.offer(second);
        }
        if (!pq.isEmpty()) {
            ans.append(pq.poll().ch);
        }
        return ans.toString();
    }

    private class charCount {
        char ch;
        int count;

        private charCount(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
