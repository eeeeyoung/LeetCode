import java.util.*;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/.
 */
public class MeetingRooms {
    private static int maxRoom;
    private static int freedBuffer;
    /**
     * First split the input array and sort the start time and end time.
     * @param intervals the input meeting room arrangements
     * @return the minimum number of rooms needed
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            starts.add(intervals[i][0]);
            ends.add(intervals[i][1]);
        }

        starts.sort(Integer::compareTo);
        ends.sort(Integer::compareTo);

        // while starts are not empty, and no available rooms, check previously freed rooms
        maxRoom = 0;
        freedBuffer = 0;
        while (!starts.isEmpty()) {
            if (starts.get(0) < ends.get(0)) {
                if (freedBuffer > 0) {
                    freedBuffer--;
                } else {
                    maxRoom++;
                }
                starts.remove(0);
            } else {
                freedBuffer++;
                ends.remove(0);
            }
        }
        return maxRoom;
    }
}
