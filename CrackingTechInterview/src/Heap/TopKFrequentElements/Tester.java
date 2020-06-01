package Heap.TopKFrequentElements;

import java.util.Arrays;

public class Tester {
    public static void main(String[] args){
        Solution s = new Solution();

        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] topKNums = s.topKFrequent(nums, k);
        System.out.println("Top " + k + " elements: " + Arrays.toString(topKNums));
    }
}
