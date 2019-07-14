import java.util.*;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/.
 */
public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> flights = null;
    LinkedList<String> paths = null;

    public List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        paths = new LinkedList<>();

        for(List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return paths;
    }

    private void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while(arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        paths.addFirst(departure);
    }
}
