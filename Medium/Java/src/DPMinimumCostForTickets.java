import java.util.ArrayList;
import java.util.HashMap;
/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/.
 *
 * In a country popular for train travel, you have planned some train travelling one year in advance.
 * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in 3 different ways:
 *
 * a 1-day pass is sold for costs[0] dollars;
 * a 7-day pass is sold for costs[1] dollars;
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 * For example, if we get a 7-day pass on day 2,
 * then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 */
public class DPMinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        // Init
        HashMap<Integer, Integer> bestCosts = new HashMap<>();
        ArrayList<Integer> travelingDays = new ArrayList<>();
        for (int d : days) {
            travelingDays.add(d);
        }

        // Base case, day 1
        if (days[0] == 1) {
            bestCosts.put(1, minOfThree(costs[0], costs[1], costs[2]));
        } else {
            bestCosts.put(1, 0);
        }

        // Loop
        for (int a = 2; a <= 365; a++) {
            if (travelingDays.contains(a)) {
                bestCosts.put(a, minOfThree(bestCosts.getOrDefault(a - 1, 0) + costs[0], bestCosts.getOrDefault(a - 7, 0)
                        + costs[1], bestCosts.getOrDefault(a - 30, 0) + costs[2]));
            } else {
                bestCosts.put(a, bestCosts.get(a - 1));
            }
        }

        return bestCosts.get(365);
    }

    /**
     * returns the minimum value of the three.
     * @param a first value
     * @param b second value
     * @param c third value
     * @return the minimum of a, b and c
     */
    public static Integer minOfThree(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static Integer maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
