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
    public void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        visitNode(root);
        inOrder(root.right);
    }

    // Print the value of the node
    public static void visitNode(Node node) {
        System.out.println(node.value + " ");
    }


    public static void main(String[] args) {
        

    }
}


