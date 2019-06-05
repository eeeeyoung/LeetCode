/**
 *
 * https://leetcode.com/problems/stone-game/.
 *
 * Alex and Lee play a game with piles of stones.
 * There are an even number of piles arranged in a row,
 * and each pile has a positive integer number of stones piles[i].
 *
 * The objective of the game is to end with the most stones.
 * The total number of stones is odd, so there are no ties.
 *
 * Alex and Lee take turns, with Alex starting first.
 * Each turn, a player takes the entire pile of stones
 * from either the beginning or the end of the row.
 * This continues until there are no more piles left,
 * at which point the person with the most stones wins.
 *
 * Assuming Alex and Lee play optimally,
 * return True if and only if Alex wins the game.
 *
 */
public class DPStoneGames {

    /**
     * Solution courtesy of https://leetcode.com/problems/stone-game/solution/.
     *
     * Approach 2: Mathematical
     *
     * Intuition and Algorithm
     *
     * Alex clearly always wins the 2 pile game.
     * With some effort, we can see that she always wins the 4 pile game.
     *
     * If Alex takes the first pile initially, she can always take the third pile.
     * If she takes the fourth pile initially, she can always take the second pile.
     * At least one of first + third, second + fourth is larger, so she can always win.
     *
     * We can extend this idea to N piles.
     * Say the first, third, fifth, seventh, etc. piles are white,
     * and the second, fourth, sixth, eighth, etc. piles are black.
     * Alex can always take either all white piles or all black piles,
     * and one of the colors must have a sum number of stones larger than the other color.
     *
     * Hence, Alex always wins the game.
     *
     *
     * @param piles whatever
     * @return true
     */
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
