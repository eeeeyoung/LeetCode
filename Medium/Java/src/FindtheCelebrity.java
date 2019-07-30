/**
 * https://leetcode.com/problems/find-the-celebrity/.
 */
public class FindtheCelebrity {
    /**
     *  a call to knows(i,j) eliminates either i or j the problem is solved.
     *  knows(i,j) == true then i can't be a celeb.
     *  since a celeb knows nobody and knows(i,j) == false then j can't be
     *  a celeb since everyone must know the celeb.
     */
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i<candidate && knows(candidate, i) || !knows(i, candidate)) return -1;
            if(i>candidate && !knows(i, candidate)) return -1;
        }
        return candidate;
    }
}
