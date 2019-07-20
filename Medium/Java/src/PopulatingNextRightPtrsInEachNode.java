/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/.
 */
public class PopulatingNextRightPtrsInEachNode {

    /**
     * 誰說 時間片刻變陳舊.
     * 全為我分秒亦停留
     * 因我 身邊有你緊握我的手
     * 而愛 誰說永不會長壽
     * 陪著你一生到白頭
     * 都能 把心中星星閃得通透
     * 陪著你走 一生一世也不分
     * 天天編出兩雙足印 過千山過千海
     * 如果 走到這世界邊端
     * 我倆已是無力前行 跟我一起飛去
     * 不相信 時間片刻變陳舊
     * 全為你分秒亦停留
     * 因你 身邊有我緊握你的手
     * 這份愛 誰說永不會長壽
     * 陪著我一生到白頭
     * 都能 把心中星星閃得通透
     * 陪著你走 一生一世也不分
     * 天天編出兩雙足印 過千山過千海
     * 如果 走到這世界邊端
     * 我倆已是無力前行 跟我一起飛去
     * 陪著你走 一生一世也不分
     * 天天編出兩雙足印 過千山過千海
     * 如果 走到這世界邊端
     * 我倆已是無力前行 跟我一起飛去
     * 一世伴你同路去
     */
    public Node connect(Node root) {
        if (root == null) return null;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
