public class BinaryTree {
    Node root;

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
    }

    // Constructor for BinaryTree
    BinaryTree(Node root) {
        this.root = root;
    }



    public static void main(String[] args) {
        
    }
}
