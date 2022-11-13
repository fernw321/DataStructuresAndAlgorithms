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





}
