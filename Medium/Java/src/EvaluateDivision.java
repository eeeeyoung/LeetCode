import java.util.HashMap;
import java.util.List;
import java.util.HashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/evaluate-division/.
 */
public class EvaluateDivision {

    private HashMap<String, HashMap<String, Double>> div = null;
    private HashSet<String> path = null;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        div = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> tmp = equations.get(i);

            HashMap<String, Double> tempMap = div.getOrDefault(tmp.get(0), new HashMap<>());
            tempMap.put(tmp.get(1), values[i]);
            div.put(tmp.get(0), tempMap);

            tempMap = div.getOrDefault(tmp.get(1), new HashMap<>());
            tempMap.put(tmp.get(0), 1 / values[i]);
            div.put(tmp.get(1), tempMap);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            path = new HashSet<>();
            double result = dfs(start, end);
            if (result != -1.0) {
                res[i] = result;
            } else {
                res[i] = -1.0;
            }
        }
        return res;
    }

    private double dfs(String start, String end) {
        if (!div.containsKey(start)) return -1.0;
        if (div.get(start).containsKey(end)) return div.get(start).get(end);

        path.add(start);
        for (Map.Entry<String, Double> neighbor : div.get(start).entrySet()) {
            if (!path.contains(neighbor.getKey())) {
                double productWeight = dfs(neighbor.getKey(), end);
                if (productWeight != -1.0) return productWeight * neighbor.getValue();
            }
        }
        return -1.0;
    }
}
