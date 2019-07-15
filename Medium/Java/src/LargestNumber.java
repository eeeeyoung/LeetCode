import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/largest-number/.
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] asStrings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrings[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(asStrings, new LargerNumberComparator());

        StringBuilder sb = new StringBuilder();
        for (String s : asStrings) {
            sb.append(s);
        }

        return sb.toString();
    }

    private class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1); // puts the bigger in front
        }
    }
}
