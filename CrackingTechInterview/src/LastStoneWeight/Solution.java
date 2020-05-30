package LastStoneWeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        if (null == stones || stones.length == 0) return 0;

        if (1 == stones.length) return stones[0];

        // convert stones to a priority queue
        PriorityQueue<Integer> stoneQueue = new PriorityQueue(stones.length, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (Integer.valueOf(o1.toString()) > Integer.valueOf(o2.toString()))
                    return -1;
                else if (Integer.valueOf(o1.toString()) < Integer.valueOf(o2.toString()))
                    return 1;

                return 0;
            }
        });

        // must convert int[] to List<Integer> because PriorityQueue's constructor accepts a Collection
        List<Integer> stoneList = IntStream.of(stones)
                                    .mapToObj(Integer::valueOf)
                                    .collect(Collectors.toList());
        stoneQueue.addAll(stoneList);

        // obtain the first two elements
        Integer number1 = stoneQueue.poll();
        Integer number2 = stoneQueue.poll();

        // calculate difference --> store non-zero value back to a PQ
        int difference = Math.abs(number1 - number2);
        if (difference > 0) {
            stoneQueue.add(difference);
        }

        // convert PQ back to array <- may convert an empty queue
        int[] newStones = Arrays.stream(stoneQueue.toArray()) // stream the array returned from stoneQueue
                .map(Object::toString)  // array is of type Object.. so obtain the element's string value.
                .map(Integer::valueOf) // from the string value, convert them to Integer object
                .mapToInt(Integer::intValue) //
                .toArray();

        // call lastStoneWeight recursively
        return lastStoneWeight(newStones);
    }
}
