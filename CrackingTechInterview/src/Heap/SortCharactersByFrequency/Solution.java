package Heap.SortCharactersByFrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    public String frequencySort(String s) {
        // empty string, "a", or "ab"
        if (null == s || s.length() <= 2) return s;

        // First, build the map of character for its count
        Map<String, Integer> charCountMap = new HashMap<>();
        for (int index=0; index<s.length(); index++){
            addToMap(charCountMap, s.charAt(index));
        }

        // build the p.q
        PriorityQueue<QueueElement> pq = new PriorityQueue<>(1, (o1, o2) -> {
            if (o1.count > o2.count) return -1;
            else if (o1.count < o2.count) return 1;
            return 0;
        });

        // add content in the map to p.q.
        charCountMap.forEach((k,v) -> pq.add(new QueueElement(k, v)));

        // pop the p.q. to construct the returned value
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            sb.append(pq.poll().print());
        }

        return sb.toString();
    }

    private void addToMap(Map<String, Integer> theMap, char toBeAdded) {
        String s = String.valueOf(toBeAdded);
        if (theMap.containsKey(s)){
            Integer currCount = theMap.get(s);
            theMap.replace(s, ++currCount);
        }
        else {
            theMap.put(s, 1);
        }
    }

    private class QueueElement {
        String s;
        int count;

        public QueueElement(String s, int count) {
            this.s = s;
            this.count = count;
        }

        public String getS(){
            return this.s;
        }

        public String print(){
            StringBuilder retVal = new StringBuilder();
            int counter = 0;
            while (counter < this.count){
                retVal.append(this.s);
                counter++;
            }

            return retVal.toString();
        }
    }
}
