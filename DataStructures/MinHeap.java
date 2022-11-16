public class MinHeap {
    private int [] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    // Constructor for the class
    MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;

        Heap = new int[this.maxsize+1];
        Heap[0] = Integer.MIN_VALUE;
    }

    // Returns the position of the parent of the currently positioned node
    private int parent(int pos) {
        return pos/2;
    }

    // Returns the position of the left child of a node
    private int leftChild(int pos) {
        return (2* pos);
    }

    // Returns the position of the right child of the node 
    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    // Returns whether the node is a leaf
    private boolean isLeaf(int pos) {
        if (pos > size/2) {
            return true;
        }
        return false;
    }

    // Swap two elements in the heap array
    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }



}
