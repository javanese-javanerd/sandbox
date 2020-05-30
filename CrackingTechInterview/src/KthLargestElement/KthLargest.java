package KthLargestElement;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
    private int k;
    private PriorityQueue<Integer> pk =  new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;

        Arrays.stream(nums).forEach(e -> {
//            System.out.println("Offering " + e);
            this.pk.add(e);
            if (this.pk.size() > this.k){
//                System.out.println("Polled out " + this.pk.peek());
                this.pk.poll();
            }
        });

//        System.out.println("Top of the *efficient* heap: " + this.pk.peek());
    }

    public int add(int val) {
//        System.out.println("Offering " + val);
        this.pk.offer(val);
        if(this.pk.size() > this.k){
//            System.out.println("Added, but polled out: " + queue.peek());
            this.pk.poll();
        }
        return this.pk.peek();
    }
}
