import java.util.HashMap;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > map = new HashMap< >();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // this part handles negative number,
            // with the existence of negative numbers
            // it is possible for multiple consecutive
            //  sums to reach the same number again
            if (map.containsKey(sum - k))
                count += map.get(sum - k);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
