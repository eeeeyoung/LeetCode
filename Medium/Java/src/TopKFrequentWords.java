import java.util.*;

/**
 * https://leetcode.com/problems/top-k-frequent-words/.
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> stringCount = new HashMap<>();
        for (String s : words) {
            stringCount.putIfAbsent(s, 0);
            stringCount.put(s, stringCount.get(s) + 1);
        }
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i;
                for (i = 0; i < o1.length() && i < o2.length(); i++) {
                    if (o1.charAt(i) != o2.charAt(i)) {
                        return o1.charAt(i) - o2.charAt(i);
                    }
                }
                if (i == o1.length()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };
        PriorityQueue<Word> pq = new PriorityQueue<>((a, b) ->
                a.count != b.count ? b.count - a.count :
                                     cmp.compare(a.string, b.string));
        for (String s : stringCount.keySet()) {
            pq.offer(new Word(s, stringCount.get(s)));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().string);
        }
        return res;
    }

    private class Word {
        String string;
        int count;
        private Word(String s, int c) {
            this.string = s;
            this.count = c;
        }
    }
}
