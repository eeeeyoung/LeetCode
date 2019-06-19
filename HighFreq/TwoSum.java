import java.util.HashMap;
/**
 * https://leetcode.com/problems/two-sum/.
 */
public class TwoSum {
    /**
     * Binary Search rules.
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                res[0] = i;
                res[1] = map.get(complement);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No such solution");
    }
}
