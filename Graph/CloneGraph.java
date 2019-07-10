import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/clone-graph/.
 */
public class CloneGraph {
    private HashMap<Integer, Node> map = new HashMap<>();
    /**
     * Using DST traversal might work?
     */
    public Node cloneGraph(Node node) {
        return clone(node);
    }

    /**
     * Recursive method for cloning a node using DFS.
     */
    private Node clone(Node node) {
        if (node == null) return null;

        // If the map has the node's reference, just return it even though
        // it might not be complete at the first pass, it's a reference to
        // the node will get updated later on.
        if (map.containsKey(node.val)) return map.get(node.val);

        Node clone = new Node(node.val, new ArrayList<>());

        // puts the reference into the map
        map.put(clone.val, clone);
        for (Node ngbr : node.neighbors) {
            clone.neighbors.add(clone(ngbr));
        }
        return clone;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
