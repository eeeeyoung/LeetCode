import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charI = s.charAt(i);
            if (charI == '{' || charI == '(' || charI == '[') {
                stack.push(charI);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char charJ = stack.pop();
                    if (charI == ')' && charJ != '(') {
                        return false;
                    }
                    if (charI == ']' && charJ != '[') {
                        return false;
                    }
                    if (charI == '}' && charJ != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
