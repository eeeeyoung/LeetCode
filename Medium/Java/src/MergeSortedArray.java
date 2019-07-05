/**
 * https://leetcode.com/problems/merge-sorted-array/.
 */
public class MergeSortedArray {
    /**
     * Filling the longer array starting from the end.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int i = m - 1, j = n - 1;
        int t = i + j + 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[t] = nums1[i];
                i--;
            } else {
                nums1[t] = nums2[j];
                j--;
            }
            t--;
        }

        // finishing off
        while (i >= 0) {
            nums1[t] = nums1[i];
            i--;
            t--;
        }
        while (j >= 0) {
            nums1[t] = nums2[j];
            j--;
            t--;
        }
    }
}
