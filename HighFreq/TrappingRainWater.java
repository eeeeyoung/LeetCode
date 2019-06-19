/**
 * https://leetcode.com/problems/trapping-rain-water/.
 */
public class TrappingRainWater {
    /**
     * two pointer marches in the array
     * @param height the input array
     * @return the amount of water trapped
     */
    public int trap(int[] height) {
        int l = height.length;
        if (l == 0) return 0;
        int left = 0, right = l - 1;
        int total = 0;
        int maxLeft = 0, maxRight = 0;
        while (left < right) {
            if (height[left] >= height[right]) {
                // advances right
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    total += maxRight - height[right];
                }
                right--;
            } else {
                // advances left
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    total += maxLeft - height[left];
                }
                left++;
            }
        }
        return total;
    }
}
