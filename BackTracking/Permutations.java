import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> org = new ArrayList<>();
        for (int num : nums) org.add(num);
        recursion(nums.length, res, org, 0);
        return res;
    }

    private void recursion(int n, List<List<Integer>> res, List<Integer> org, int first) {
        if (n == first) {
            res.add(new ArrayList<>(org));
        } else {
            for (int i = first; i < n; i++) {
                Collections.swap(org, first, i);
                recursion(n, res, org, first + 1);
                Collections.swap(org, first, i);
            }
        }
    }
}
