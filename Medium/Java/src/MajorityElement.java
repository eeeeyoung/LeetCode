import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/.
 */
public class MajorityElement {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int major1 = 0; int major2 = 1; int count1 = 0; int count2 = 0;
        for (int val : nums) {
            if (major1 == val) {
                count1++;
            } else if (major2 == val) {
                count2++;
            } else if (count1 == 0) {
                major1 = val;
                count1++;
            } else if (count2 == 0) {
                major2 = val;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        // second pass
        count1 = 0; count2 = 0;
        for (int val : nums) {
            if (major1 == val) count1++;
            if (major2 == val) count2++;
        }
        if (count1 > (nums.length) / 3) res.add(major1);
        if (count2 > (nums.length) / 3) res.add(major2);
        return res;
    }
}
