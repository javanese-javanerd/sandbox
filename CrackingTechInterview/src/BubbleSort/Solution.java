package BubbleSort;

import java.util.Scanner;

/**
Sample Input 0
	3
	1 2 3

Sample Output 0
	Array is sorted in 0 swaps.
	First Element: 1
	Last Element: 3

Explanation 0 
	The array is already sorted, so  swaps take place and we print the necessary three lines of output shown above.

Sample Input 1
	3
	3 2 1

Sample Output 1
	Array is sorted in 3 swaps.
	First Element: 1
	Last Element: 3

Explanation 1 
	The array is not sorted, and its initial values are: {3,2,1}
	The following  swaps take place:
		{3,2,1} --> {2,3,1}
		{2,3,1} --> {2,1,3}
		{2,1,3} --> {1,2,3}	
	At this point the array is sorted and we print the necessary three lines of output shown above.
	
 * @author javanese-javanerd
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++){
            a[i] = in.nextInt();
        }
        
        bubbleSort(a);
    }
    
    public static void bubbleSort(int[] a){
        // Track number of elements swapped during a single array traversal
        int numberOfSwaps = 0;
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                }
            }
        }
        
        System.out.println("Array is sorted in " + numberOfSwaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }
    
    private static void swap(int[] a, int position1, int position2){
        int temp = a[position1];
        a[position1] = a[position2];
        a[position2] = temp;
    }
}
