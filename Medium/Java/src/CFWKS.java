import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CFWKS {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // HashMap map stores the adjacency edges from cities to cities
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // pq entries:
        // entry[0] = price of the flight
        // entry[1] = destination
        // entry[2] = remaining stops
        pq.offer(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] entry = pq.poll();
            int price = entry[0];
            int dest = entry[1];
            int stops = entry[2];
            if (dst == dest) return price;
            if (stops > 0) {
                Map<Integer, Integer> adj = map.getOrDefault(dest, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[]{price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;  // pq is empty
    }
}
