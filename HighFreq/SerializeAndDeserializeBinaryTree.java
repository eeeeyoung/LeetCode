import java.util.Arrays;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/.
 */
public class SerializeAndDeserializeBinaryTree {
    //
    // Tested versions with StringJoiner and StringBuilder
    //
    // Performance differences:
    // (1) StringJoiner, 8 ms, 39.4 MB
    // (2) StringBuilder 8 ms, 39.4 MB
    //
    //  Did not test StringBuffer, typically slower than these 2 because
    //  it is thread safe.
    //
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb = recursSerialize(sb, root);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> ll = new LinkedList<>(Arrays.asList(data.split(",")));
        return recursDeserialize(ll);
    }

    private StringBuilder recursSerialize(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("#");
            return sb;
        }
        sb.append(String.valueOf(node.val)).append(",");
        sb = recursSerialize(sb, node.left).append(",");
        sb = recursSerialize(sb, node.right);
        return sb;
    }

    private TreeNode recursDeserialize(LinkedList<String> ll) {
        if (!ll.isEmpty()) {
            String p = ll.pop();
            if (p.equals("#")) return null;
            TreeNode newNode = new TreeNode(Integer.parseInt(p));
            newNode.left = recursDeserialize(ll);
            newNode.right = recursDeserialize(ll);
            return newNode;
        } else {
            return null;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
