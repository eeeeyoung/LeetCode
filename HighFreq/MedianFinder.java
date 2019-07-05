import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/.
 */
public class MedianFinder {

    // Solution from:
    // https://leetcode.com/problems/find-median-from-data-stream/solution/
    // Using priority queue as heaps
    // Note: The default PriorityQueue is implemented with Min-Heap

    /**
     * initialize your data structure here.
     * small is a "maxheap", the author takes the negative value from large
     * large is a minheap, smallest value on top
     */
    private Queue<Long> small = new PriorityQueue<>(),
                        large = new PriorityQueue<>();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());

        // balancing the heaps,
        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }
}
