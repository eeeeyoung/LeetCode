public class BST implements BSTInterface {

    private Node root;

    @Override
    public boolean find(int key) {
        if (root == null) return false;

        Node current = root;
        while (current.key != key) {
            if (current.key < key) {
                current = current.right;
            } else {
                current = current.left;
            }

            if (current == null) return false;
        }

        return true;
    }

    @Override
    public void insert(int key, double value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            return;
        }

        Node parent = root;
        Node current = root;
        while (true) {
            if (current.key == key) return;
            parent = current;
            if (current.key < key) {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            } else {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            }  // end of go right or left
        }  // end of while loop
    }  // end of insert method

    /**
     * Four cases to consider:
     * 1) key does not exists
     * 2) key is a leaf
     * 3) key has one child
     * 4) key has two children
     * @param key the key to delete
     */
    @Override
    public void delete(int key) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = true;

        while (current.key != key) {
            parent = current;
            if (current.key < key) {
                current = current.right;
                isLeftChild = false;
            } else {
                isLeftChild = true;
                current = current.left;
            }

            // case one: key not found
            if (current == null) return;

            // case two: key node is a leaf
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else if (isLeftChild) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }

            // case three: key node is a node with one child
            } else if (current.right == null ) {
                if (current == root) {
                    root = current.left;
                } else if (isLeftChild) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else if (isLeftChild) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else {
                // case 4: two children
                Node successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
                successor.left = current.left;
            }
        }
    }

    /**
     * Helper method to find successor, next-highest key after to Delete.
     *
     * Basically,
     * The successor node is the smallest node (key)
     * in the right sub-tree of the node to be deleted.
     */
    private Node getSuccessor(Node toDelete) {
        Node sp = toDelete;
        Node successor = toDelete;
        Node current = toDelete.right;

        while (current != null) {
            sp = successor;
            successor = current;
            current = current.left;
        }

        if (successor != toDelete.right) {
            sp.left = successor.right;
            successor.right = toDelete.right;
        }

        return successor;
    }

    @Override
    public void traverse() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node node) {
        if (node == null) return;
        inOrderHelper(node.left);
        System.out.println(node);
        inOrderHelper(node.right);
    }


    private static class Node {
        private int key;
        private double value;
        private Node left, right;

        Node(int k, double v) {
            key = k;
            value = v;
            left = null;
            right = null;
        }
    }
}
