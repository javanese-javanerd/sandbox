package Heap.KthLargestElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 *
 * You may assume that and k ≥ 1 and array nums' length ≥ k-1.
 */
public class KthLargestInefficient {
    private int k;
    private PriorityQueue pq;

    public KthLargestInefficient(int k, int[] nums) {
        this.k = k;

        List<Integer> numList = IntStream.of(nums)
                                    .mapToObj(Integer::valueOf)
                                    .collect(Collectors.toList());

        // Older PQ interface didn't allow size of 0.
        int size = nums.length < 1 ? 1 : nums.length;
        this.pq = new PriorityQueue(size, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                // We want the highest value at the top of the heap
                if (Integer.valueOf(o1.toString()) > Integer.valueOf(o2.toString())){
                    return -1;
                }
                else if (Integer.valueOf(o1.toString()) < Integer.valueOf(o2.toString())){
                    return 1;
                }
                else return 0;
            }
        });

        this.pq.addAll(numList);
//        System.out.println("Top of the *brute-force* heap: " + pq.peek());
    }

    /**
     * Assumption: val can be negative, positive, or zero.
     *
     * @param val
     * @return
     */
    public int add(int val) {
        // add val to pq
        pq.add(Integer.valueOf(val));

        // create a list to hold polled elements
        List<Integer> polled = new ArrayList<>();

        // loop k times to poll kth element
        for (int counter = 0; counter < k; counter++) {
            polled.add(Integer.valueOf(pq.poll().toString()));
        }
        int retVal = polled.get(k-1);

        // readd list to pq
        pq.addAll(polled);

        return retVal;
    }
}
