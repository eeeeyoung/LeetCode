import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/gray-code/.
 */
public class GrayCode {

    /* JAVA DOES NOT HAVE AN EQUIVALENT OF UNSIGNED VALUE */
    /* C TO THE RESCUE! OR USE LONG INSTEAD OF INT */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
