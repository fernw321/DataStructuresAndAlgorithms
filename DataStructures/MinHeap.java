/* The range of leaves in a MinHeap is from N/2 to (N-1)
The range of the internal nodes is 0 to N/2 -1
 N is the size of the Heap array
 */


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

    // Percolates each inserted elemented up until it is the min element for its substree
    private void minHeapify(int pos) {
        int parent = parent(pos);

        if (parent >= 1) {
            if (Heap[pos] < Heap[parent]) {
                swap(pos,parent);
                minHeapify(parent);
            }
        }

        return;

    }
    // Insert elements into the Heap in left-to right order on the leafy level
    public void insert(int element) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        minHeapify(size);
    }
    

    // Print the contents of the heap. Only iterating to half the size of the heap is necessary; half of the nodes are on the last level
    public void print() {
        for (int i = 1; i <= size/2; i++) {
            System.out.print(
                " Parent: " + Heap[i]
                + " Left child:  " + Heap[2*i]
                + " Right child: " + Heap[2*i+1]);

                System.out.println();
        }
    }

    // Code executiong starts here
    public static void main(String[] args) {
        MinHeap heap = new MinHeap(7);
        for (int i = 7; i > 0; i--) {
            heap.insert(i);
        }

        heap.print();
    }



}
