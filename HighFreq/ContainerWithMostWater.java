/**
 * https://leetcode.com/problems/container-with-most-water/.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int containerLength = height.length;
        int maxLeftIndex, maxRightIndex, i, j, maxWater;
        if (containerLength < 2) return 0;
        i = 0;
        maxLeftIndex = i;
        j = containerLength - 1;
        maxRightIndex = j;
        maxWater = Math.min(height[maxLeftIndex], height[maxRightIndex])
                * (maxRightIndex - maxLeftIndex);

        // recursion
        while (i < j) {
            if (height[i] < height[j]) {
                i++;
                if (height[i] > height[maxLeftIndex]) maxLeftIndex++;
            } else {
                j--;
                if (height[j] > height[maxRightIndex]) maxRightIndex--;
            }
            maxWater = Math.max(maxWater, (Math.min(height[i], height[j])
                    * (i - j)));
        }
        return maxWater;
    }
}
