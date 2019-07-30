/**
 * https://leetcode.com/problems/zigzag-conversion/.
 */
public class ZigZagConversion {
    /**
     * Input: s = "PAYPALISHIRING", numRows = 3
     * Output: "PINALSIGYAHRPI"
     * Explanation:
     *
         P   A   H   N
         A P L S I I G
         Y   I   R
     *
     */
    public String convert(String s, int numRows) {
        if (s == null || s.equals("")) return "";
        if (numRows <= 1) return s;

        int strlen = s.length();
        int ptr, tempPtr;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int diff = 2 * numRows - 2;  // diff = 4
            int middiff = diff - 2 * i;  // middiff = 4, 2, 0
            ptr = i;
            tempPtr = i;

            while (ptr < strlen) {
                /* Append starting ptr */
                sb.append(s.charAt(ptr));
                ptr += diff;
                if (ptr < strlen) {
                    sb.append(s.charAt(ptr));
                } else {
                    break;
                }

                if (middiff != diff && middiff != 0) {
                    sb.append(s.charAt(tempPtr += middiff));
                } else {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
