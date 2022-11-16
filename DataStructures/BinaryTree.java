class Node {
    int value;
    Node left;
    Node right;

    // Constructor for node
    Node(int value) {
        this.value= value;
    }

    public void setLeftChild(Node child) {
        this.left = child;
    }

    public void setRightChild(Node child) {
        this.right = child;
    }

    // In-order traversal
    public static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        visitNode(root);
        inOrder(root.right);
    }

    // Pre-order traversal
    public static void preOrder(Node root) {
        if (root == null) return;

        visitNode(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    // Post-order traversal
    public static void postOrder(Node root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        visitNode(root);
    }

    // Print the value of the node
    public static void visitNode(Node node) {
        System.out.println(node.value + " ");
    }


    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);

        postOrder(root);

    }
}


