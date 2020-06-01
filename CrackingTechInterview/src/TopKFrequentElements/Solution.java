package TopKFrequentElements;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // base case
        if (null == nums || nums.length == 1) {
            return nums;
        }

        // streams nums array and generate the map
        Map<Integer, Integer> numsMap = new HashMap<>();
        Arrays.stream(nums).forEach(n -> addToMap(numsMap, n));

        // construct the priority queue from array
        PriorityQueue<NumElement> pq = new PriorityQueue<>(1, (o1, o2) -> {
            if (o1.count < o2.count) return -1;
            else if (o1.count > o2.count) return 1;
            return 0;
        });

        numsMap.forEach((key, value) -> {
            // add to pq
            pq.add(new NumElement(key, value));

            // pop pq if size > k
            if (pq.size() > k) {
                pq.poll();
            }
        });

        // construct the returned array
        List<Integer> topKList = new ArrayList<>();
        pq.forEach(e -> topKList.add(e.key));

        return topKList.stream().mapToInt(Integer::intValue).toArray();
    }

    private void addToMap(Map<Integer, Integer> numsMap, int n){
        if (numsMap.containsKey(n)){
            int currentCount = numsMap.get(n);
            numsMap.replace(n, ++currentCount);
        }
        else {
            numsMap.put(n, 1);
        }
    }

    private class NumElement {
        Integer key;
        Integer count;

        public NumElement(int key, int count){
            this.key = key;
            this.count = count;
        }

    }
}