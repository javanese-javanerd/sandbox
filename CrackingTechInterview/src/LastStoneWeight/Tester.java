package LastStoneWeight;

import java.util.Timer;

public class Tester {
    public static void main(String args[]){
        Solution sol = new Solution();

        int[] test1 = {2,7,4,1,8,1};
        int[] test2  = {2,2};
        int[] test3  = {1000,900,800,700,600,500,400,300,200,100,90,80,70,60,50,40,30,20,10,9,8,7,6,5,4,3,2,1,0};

        System.out.println("Test1: " + sol.lastStoneWeight(test1));
        System.out.println("Test2: " + sol.lastStoneWeight(test2));
        System.out.println("Test3: " + sol.lastStoneWeight(test3));
    }
}
