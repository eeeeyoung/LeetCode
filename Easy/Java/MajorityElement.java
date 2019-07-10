/**
 * https://leetcode.com/problems/majority-element/.
 */
public class MajorityElement {
    /**
     * Solution using the Boyer-Moore Voting Algorithm.
     * @param nums the input integer array
     * @return the majority element
     */
    public int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for (int i : nums) {
            if (count == 0) {
                candidate = i;
                count++;
            } else {
                count += (i == candidate) ? 1 : -1;
            }
        }
        return candidate;
    }
}
