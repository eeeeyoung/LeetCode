import java.util.Arrays;

/**
 * Merge Sort Implementation
 */
public class Sorting {

    /**
     * public method to verify and load the initial unsorted array.
     * @param unsorted the input array
     */
    public static void mergeSort(int[] unsorted) {
        if (unsorted == null || unsorted.length <= 1) {
            return;
        }
        int[] to = new int[unsorted.length];
        mergeSort(unsorted, to, 0, unsorted.length - 1);
    }

    /**
     * private recursive function to merge sort the input array
     * using divide-and-conquer
     * @param from the input array
     * @param to to auxiliary array to use
     * @param left the lower boundary of the current array in from
     * @param right the upper boundary of the current array in from
     */
    private static void mergeSort(int[] from, int[] to, int left, int right) {
        // base case
        if (left >= right) {
            return;
        }
        // recursive case, find midpoint
        int mid = left + (right - left) / 2;
        // mergeSort the left child array
        mergeSort(from, to, left, mid);
        // mergeSort the right child array
        mergeSort(from, to, mid + 1, right);
        // merge the two sorted child arrays
        merge(from, to, left, mid + 1, right);
    }

    /**
     * private helper function to merge two underlying child arrays.
     * Only uses two arrays
     * @param from input array
     * @param to auxiliary array to use during merge process
     * @param leftPos starting point of left half
     * @param rightPos starting point of right half
     * @param rightBound upper bound of right half
     */
    private static void merge(int[] from, int[] to, int leftPos, int rightPos, int rightBound) {
        // bounds of left half
        int leftBound = rightPos - 1;
        // index of to array, starting point of left half
        int toIndex = leftPos;
        // total number of items to examine
        int numItems = rightBound - leftPos + 1;

        // filter from left and right halves
        while (leftPos <= leftBound && rightPos <= rightBound) {
            if (from[leftPos] <= from[rightPos]) {
                to[toIndex++] = from[leftPos++];
            } else {
                to[toIndex++] = from[rightPos++];
            }
        }

        // copy rest of left and right halves
        while (leftPos <= leftBound) {
            to[toIndex++] = from[leftPos++];
        }
        while (rightPos <= rightBound) {
            to[toIndex++] = from[rightPos++];
        }

        /* Post Process that needs to be done. Why is it needed? */
        for (int i = 0; i < numItems; i++, rightBound--) {
            from[rightBound] = to[rightBound];

            // ofc you need to update the original array!
        }
    }

    /**
     * A version of quickSort, public function.
     * @param array the input array
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Recursive method to sort an array using quick sort.
     * @param array the input array
     * @param left left boundary
     * @param right right boundary
     */
    private static void quickSort(int[] array, int left, int right) {
        int leftPointer = left;
        int rightPointer = right;

        // Get the pivot value
        int pivot = array[left + (right - left) / 2];

        while (leftPointer <= rightPointer) {
            // inner loop
            while (array[leftPointer] < pivot) {
                leftPointer++;
            }
            while (array[rightPointer] > pivot) {
                rightPointer--;
            }
            if (leftPointer <= rightPointer) {
                swap(array, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
        }

        // Recursion
        if (left < rightPointer) {
            quickSort(array, left, rightPointer);
        }
        if (leftPointer < right) {
            quickSort(array, leftPointer, right);
        }
    }

    /**
     * helper method to swap two values in an array.
     * @param array array to modify
     * @param one first index value
     * @param two second index value
     */
    private static void swap(int[] array, int one, int two) {
        int tmp = array[one];
        array[one] = array[two];
        array[two] = tmp;
    }
}
