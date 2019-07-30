import java.util.Arrays;

/**
 * https://leetcode.com/problems/reorder-log-files/.
 */
public class ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] halves1 = log1.split(" ", 2);
            String[] halves2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(halves1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(halves2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = halves1[1].compareTo(halves2[1]);
                if (cmp != 0) return cmp;
                else {
                    return halves1[0].compareTo(halves2[0]);
                }
            }
            if (isDigit1 && isDigit2) {
                return 0; // 0 is original order
            }
            return isDigit1 ? 1 : -1;
        });
        return logs;
    }
}
