/**
 * https://leetcode.com/problems/sort-colors/.
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null) return;
        mergeSort(nums);
    }

    private void mergeSort(int[] from) {
        // create a new array
        int[] to = new int[from.length];
        mergeSort(from, to, 0, from.length-1);
    }

    private void mergeSort(int[] from, int[] to, int start, int end) {
        if (start >= end) return;
        // int finding midpoint
        int mid = start + (end - start) / 2;
        mergeSort(from, to, start, mid);
        mergeSort(from, to, mid + 1, end);

        merge(from, to, start, mid + 1, end);
    }

    private void merge(int[] from, int[] to, int leftStart, int rightPos, int rightBound) {
        int leftBound = rightPos - 1;
        int toIndex = leftStart;
        int numItems = rightBound - leftStart + 1;

        while (leftStart <= leftBound && rightPos <= rightBound) {
            if (from[leftStart] > from[rightPos]) {
                to[toIndex] = from[rightPos];
                rightPos++;
            } else {
                to[toIndex] = from[leftStart];
                leftStart++;
            }
            toIndex++;
        }

        // finishing up
        while (leftStart <= leftBound) {
            to[toIndex] = from[leftStart];
            leftStart++;
            toIndex++;
        }
        while (rightPos <= rightBound) {
            to[toIndex] = from[rightPos];
            rightPos++;
            toIndex++;
        }

        for (int i = 0; i < (numItems); i++, rightBound--) {
            from[rightBound] = to[rightBound];
        }
    }
}
