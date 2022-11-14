import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K, V> {
    // Store array of nodes for the table
    private ArrayList<HashNode<K, V>> array;
    // Store the number of head nodes in the table
    private int numNodes;
    // Holds the current size of the table
    private int size; 

    // HashNode class
    class HashNode<K, V> {
        K key;
        V value;
        final int hashCode;
        HashNode<K,V> next;


        // Constructor
        public HashNode(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
        }

    }

    // Constructor
    public HashTable(){
        array = new ArrayList<>();
        numNodes = 10;
        size = 0;
        // Fill the node array with nulls
        for (int i = 0; i < numNodes; i++) {
            array.add(null);
        }
    }

    // Return current size of ? 
    public int size() { return size; }

    // Returns wether or not the HashTable is empty
    public boolean isEmpty() { return size() == 0; }

    // We use the hashing function found in the Objects library for our keys
    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }
    
    // Retrieves the index of the head node in the HashTable array
    private int getHeadNodeIndex(K key) {
        int hashCode = hashCode(key);
        // Maps the index using the following equation
        int index = hashCode%numNodes;

        // Handle case where the index may be negative
        index = index < 0 ? index*-1 : index;
        return index;
    }

    // Method to remove a given key
    public V remove(K key) {
        // Retrieve index of the headnode that contains key
        int index = getHeadNodeIndex(key);
        int hashCode = hashCode(key);
        // Head node of the singly linked node list
        HashNode<K, V> head = array.get(index);
        // Keep track of the previous node
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode) {
                break;
            } else {
                prev = head;
                head = head.next;
            }
        }

        // If a matching key was not found
        if (head == null) {
            return null;
        }

        // Reduce size of the HashTable
        size--;

        // Remove the matching node with the key
        // If prev is null, that means the head node is the match
        if (prev != null) {
            prev.next = head.next;
        } else {
            array.set(index, head.next);
        }

        return head.value;


    } // End remove method


    // Returns value from a key
    public V get(K key) {
        // Retrieve the index of the array that contains the key
        int index = getHeadNodeIndex(key);
        int hashCode = hashCode(key);
        // Runner node
        HashNode<K, V> head = array.get(index);
        // Traverse the node list
        while (head != null) {
            if (head.key.equals(key) && hashCode == head.hashCode) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    } // end get method

    public void add(K key, V value) {
        // Retrieve the index in the array 
        int index = getHeadNodeIndex(key);
        int hashCode = hashCode(key);

        // Retrieve the head node of given index
        HashNode<K, V> head = array.get(index);
        
        while (head != null) {
            // Update the value if the key already exists
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
            }
            head = head.next;
        }

        // Insert the key at the beginning of the chain
        size++;
        head = array.get(index);
        // Construct the new node
        HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
        // Set the new chain 
        newNode.next = head;
        array.set(index, newNode);

        // Handling load factor: if threshold exceeded, double the HashTable size
        if ((1.0 * size) / numNodes >= 0.7) {
            // Copy over the original 
            ArrayList<HashNode<K, V>> temp = array;
            // Empty the original array
            array = new ArrayList<>();
            // Double the number of head nodes
            numNodes *= 2;
            // Reset the size
            size = 0;
            for (int i = 0; i < numNodes; i++) {
                array.add(null);
            }
            // Add all nodes from temp array to new array
            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }

        }

    }








    // Start of code execution
    public static void main(String[] args) {
        
    }


}
