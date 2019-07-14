import java.net.SecureCacheResponse;
import java.util.NoSuchElementException;

public class MaxHeap implements MaxHeapInterface {
    private Node[] heapArray;
    private int currentSize;

    public MaxHeap(int initialCapacity) {
        heapArray = new Node[initialCapacity];
        currentSize = 0;
    }

    public boolean insert(int key) {
        if (currentSize == heapArray.length) return false;
        heapArray[currentSize] = new Node(key);
        percolateUp(currentSize);
        currentSize++;
        return true;
    }

    public int removeMax() {
        if (currentSize == 0) {
            throw new NoSuchElementException("The heap is empty.");
        }
        Node root = heapArray[0];
        currentSize--;
        heapArray[0] = heapArray[currentSize];
        heapArray[currentSize] = null;
        percolateDown(0);
        return root.key;
    }

    private void percolateDown(int index) {
        Node top = heapArray[index];
        int largerChild;
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].key < heapArray[rightChild].key) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (heapArray[largerChild].key <= top.key) break;
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    private void percolateUp(int index) {
        Node bottom = heapArray[index];

        int parent = (index - 1) / 2;

        while (index > 0 && heapArray[parent].key < bottom.key) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }

        heapArray[index] = bottom;
    }

    private static class Node {
        private int key;
        Node (int key) {
            this.key = key;
        }
    }
}
