import java.util.List;

/**
 * https://leetcode.com/problems/clone-graph/.
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {

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
