/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/.
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 */
public class medianOfTwoSortedArrays {

    /**
     * https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2481
     * /Share-my-O(log(min(mn))-solution-with-explanation.
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 > l2) {
            // flipping arrays
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        int imin = 0;
        int imax = l1;  // the smaller array's length
        int half = (l1 + l2 + 1) / 2;

        // recursion
        int i, j, max_of_left, min_of_right;
        while (imin <= imax) {
            i = imin + (imax - imin) / 2;  // taking the middle point
            j = half - i;  // complementary position of i

            // BINARY SEARCH
            if (i < l1 && nums2[j - 1] > nums1[i]) {
                imin = i + 1;  // adjust the lower to mid point + 1
            } else if (i > 0 && nums1[i - 1] > nums2[j]) {  // i could == 0
                imax = i - 1;  // adjust the upper to mid point - 1
            }

            else {
                // position of i is just right
                if (i == 0) {
                    max_of_left = nums2[j - 1];
                } else if (j == 0) {
                    max_of_left = nums1[i - 1];
                } else {
                    max_of_left = Math.max(nums1[i-1], nums2[j-1]);
                }
                if ((l1 + l2) % 2 == 1) {
                    return max_of_left;
                }
                // even number of total array length

                if (i == l1) {
                    min_of_right = nums2[j];
                } else if (j == l2) {
                    min_of_right = nums1[i];
                } else {
                    min_of_right = Math.min(nums1[i], nums2[j]);
                }

                return (max_of_left + min_of_right) / 2.0;
            }
        }
        return 0;
    }
}
