import java.util.ArrayList;

/**
 * LeetCode: https://leetcode.com/problems/divisor-game/.
 * TODO: verify the logic for finding divisors
 */
public class DPDivisorGame {

    public boolean divisorGame(int N) {

        boolean[] wl = new boolean[N + 1];

        // base case
        wl[1] = false;
        wl[2] = true;

        ArrayList<Integer> divs;
        for (int i = 3; i <= N; i++) {
            divs = findAllDivisors(i);
            boolean flag = false;
            for (Integer j : divs) {
                // if ever wl lands on false for opponent, then will for Alice in next move
                if (!wl[i - j]) {
                    flag = true;
                    break;
                }
            }
            wl[i] = flag;
        }
        return wl[N];
    }

    /**
     * Helper function to return all Divisors of integer N.
     * Need to figure out what is the upperbound is for searching divisors
     * @param N interger N
     * @return an array containing all divisors of N
     */
    private ArrayList<Integer> findAllDivisors(int N) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 2; i < Math.sqrt(N); i++) {
            if (N % i == 0) {
                res.add(i);
            }
        }
        res.add(1);
        return res;
    }
}
