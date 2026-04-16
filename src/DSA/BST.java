package DSA;

public class BST {
    Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public BST() {
        root = null;
    }

    public void insert(int value) {
        root = insertHelper(root, value);
    }

    public void remove(int value) {
        root= removeHelper(root, value);
    }

    public Node search(int value) {
        return searchHelper(root, value);
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    private Node insertHelper(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insertHelper(node.left, value);
        } else if (value > node.value) {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    private Node removeHelper(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.value) {
            node.left = removeHelper(node.left, value);
        } else if (value > node.value) {
            node.right = removeHelper(node.right, value);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            node.value = successor.value;
            node.right = removeHelper(node.right, successor.value);
        }
        return node;
    }

    private Node searchHelper(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        if (value < node.value) {
            return searchHelper(node.left, value);
        } else {
            return searchHelper(node.right, value);
        }
    }
}
