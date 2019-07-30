import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-k-digits/.
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        int strlen = num.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < strlen; i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.charAt(0) == '0' && sb.length() != 1) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
