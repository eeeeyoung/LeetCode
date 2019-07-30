/**
 * https://leetcode.com/problems/maximum-swap/.
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int[] count = new int[10];
        for (int i = 0; i < charArray.length; i++) {
            count[charArray[i] - '0'] = i;
        }

        for (int i = 0; i < charArray.length; i++) {
            for (int d = 9; d > charArray[i] - '0'; d--) {
                if (count[d] > i) {
                    // greedy swap
                    // there is a number greater than the number at i
                    char temp = charArray[i];
                    charArray[i] = charArray[count[d]];
                    charArray[count[d]] = temp;
                    return Integer.valueOf(new String(charArray));
                }
            }
        }
        return num;
    }
}
