import java.util.ArrayList;

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





}
