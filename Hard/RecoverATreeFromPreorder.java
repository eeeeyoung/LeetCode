import java.util.Stack;

/**
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/.
 */
public class RecoverATreeFromPreorder {
    /**
     * Typically using stack avoid recursions, but worse runtime:
     * 9 ms, 38.2MB
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.equals("")) return null;
        int strlen = S.length();
        int strIndex = 0;

        Stack<TreeNode> stack = new Stack<>();

        // recursion
        while (strIndex != strlen) {
            int level = 0;
            while (S.charAt(strIndex) == '-') {
                level++;
                strIndex++;
            }
            StringBuilder next = new StringBuilder();
            while (strIndex < strlen && S.charAt(strIndex) != '-') {
                next.append(S.charAt(strIndex));
                strIndex++;
            }
            int nextInt = Integer.parseInt(next.toString());

            while (level < stack.size()) {
                stack.pop();
            }

            TreeNode node = new TreeNode(nextInt);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.add(node);
        }
        while (stack.size() > 1) stack.pop();
        return stack.pop();
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
