import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String trimmed = s.trim();
        char[] charArray = trimmed.toCharArray();
        StringBuilder sb = new StringBuilder();
        int arrlen = charArray.length;

        Deque<Character> deque = new ArrayDeque<>();
        for (int ori = arrlen - 1; ori >= 0; ori--) {
            if (charArray[ori] == ' ') {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                }
                if (sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            } else {
                deque.addLast(charArray[ori]);
            }
        }
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
