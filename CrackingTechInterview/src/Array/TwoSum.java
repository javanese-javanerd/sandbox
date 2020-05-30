package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TwoSum {

    public int[] twoSum_n_sq(int[] nums, int target) {
        int[] indices = new int[2];
        for (int pivot = 0; pivot < nums.length; pivot++){
            for (int index = pivot+1; index < nums.length; index++){
                if (target == nums[pivot] + nums[index]) {
                    indices[0] = pivot;
                    indices[1] = index;
                }
            }
        }
        return indices;
    }

    public int[] twoSum_n(int[] nums, int target){
        int[] indices = new int[2];
        Map<Integer, Integer> temp = new HashMap<>();
        for (int index=0; index < nums.length; index++){
            int dif = target - nums[index];
            if (temp.containsKey(dif)){
                indices[0] = index;
                indices[1] = temp.get(dif);
                return indices;
            }
            temp.put(nums[index], index);
        }

        return indices;
    }

    public static void main(String args[]){
        TwoSum ts = new TwoSum();
        int[] input = {3,5,7,11,9,8,19};
        int[] indices = ts.twoSum_n_sq(input,17);
        IntStream s = Arrays.stream(indices);
        s.forEach(x -> System.out.println(x));
        indices = ts.twoSum_n(input, 17);
        s = Arrays.stream(indices);
        s.forEach(x -> System.out.println(x));
    }
}
