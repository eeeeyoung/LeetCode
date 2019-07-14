/**
 * Java Interface for Max Heap.
 *
 * @author Yang YI
 */
public interface MaxHeapInterface {

    /**
     * Inserts a new key into a heap.
     * @param key key to insert
     * @return boolean to check whether it was inserted or not
     */
    boolean insert(int key);

    /**
     * Removes the highest priority key (maximum for max heap).
     * @return removed key. Exception if empty
     */
    int removeMax();
}
