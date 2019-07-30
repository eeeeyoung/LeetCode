import java.util.PriorityQueue;

/**
 * https://leetcode.com/discuss/interview-question/330356/Amazon-or-Online
 * -Assessment-2019-or-Longest-string-without-3-consecutive-characters.
 */
public class LongestStringWithoutThreeConsecutives {

    private static String constructString(int A, int B, int C) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Word> pq =
                new PriorityQueue<>((a, b) -> (b.anInt - a.anInt));
        pq.offer(new Word('a', A));
        pq.offer(new Word('b', B));
        pq.offer(new Word('c', C));

        Word word1, word2;
        while (!pq.isEmpty()) {
            word1 = pq.poll();
            word2 = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != word1.aChar) {
                int count1 = word1.anInt;
                int times = Math.min(count1, 2);
                for (int i = 0; i < times; i++) {
                    sb.append(word1.aChar);
                    word1.anInt--;
                }
                if (word1.anInt > 0) pq.offer(word1);
                if (word2 != null) {
                    sb.append(word2.aChar);
                    word2.anInt--;
                    if (word2.anInt > 0) pq.offer(word2);
                }
            } else {
                if (word2 != null) {
                    sb.append(word2.aChar);
                    word2.anInt--;
                    if (word2.anInt > 0) pq.offer(word2);
                }
                int count1 = word1.anInt;
                int times = Math.min(count1, 2);
                for (int i = 0; i < times; i++) {
                    sb.append(word1.aChar);
                    word1.anInt--;
                }
                if (word1.anInt > 0) pq.offer(word1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = args[0];
        String[] inputSplit = input.split(" ");
        int A = inputSplit[0].charAt(0) - '0';
        int B = inputSplit[1].charAt(0) - '0';
        int C = inputSplit[2].charAt(0) - '0';
        System.out.println(constructString(A, B, C));
    }

    private static class Word {
        char aChar;
        int anInt;

        private Word(char c, int i) {
            this.aChar = c;
            this.anInt = i;
        }
    }
}
