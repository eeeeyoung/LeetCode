import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/.
 */
public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res =  new ArrayList<>();

        // assume sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        int[] resArray = new int[res.size()];
        for (int a = 0; a < res.size(); a++) {
            resArray[a] = res.get(a);
        }
        return resArray;
    }
}
