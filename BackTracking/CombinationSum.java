import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        recursion(candidates.length, 0, res, list, candidates, target);
        return res;
    }

    private void recursion(int n, int pos, List<List<Integer>> res,
                           List<Integer> list, int[] candidates, int target) {
        // termination condition
        if (target == 0) {
            res.add(list);
        } else {
            if (pos == n) return;
            int count = 0;
            int currNum = candidates[pos];
            int cumSum = target;
            while (count * currNum <= target) {
                // My original code here is slow because it creates a new
                // instance of temp list every time the while loop is being called,
                // whereas the "alt" solution only creates the "actual" new list
                // when the target is reached at termination
                //
                // The reference answer also used proper backtracking by removing
                // the last element from the list afterwards, thus able to reuse
                // the same reference without creating a new one
                List<Integer> temp = new ArrayList<>(list);
                for (int j = 0; j < count; j++) temp.add(currNum);
                recursion(n, pos + 1, res, temp, candidates, target - count * currNum);
                count++;
            }
        }
    }
}
