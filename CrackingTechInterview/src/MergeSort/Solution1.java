package MergeSort;

import java.util.Arrays;

/**
 * Print a sorted array of integer using merge sort.
 * 
 * @author javanese-javanerd
 */
public class Solution1 {

	/**
	 * Return a sorted array
	 * 
	 * @param toBeSorted
	 * @return
	 */
	public int[] sort(int[] toBeSorted) {
		if (null == toBeSorted || toBeSorted.length == 0) return null;
				
		if (toBeSorted.length == 1) return toBeSorted;
		
		if (toBeSorted.length == 2) {
			if (toBeSorted[0] > toBeSorted[1]) {
				int tmp = toBeSorted[0];
				toBeSorted[0] = toBeSorted[1];
				toBeSorted[1] = tmp;
			}	
			return toBeSorted;
		}
		
		// splitting array into two halves
		int midIndex = toBeSorted.length/2;
		return merge(sort(Arrays.copyOfRange(toBeSorted, 0, midIndex)), 
				sort(Arrays.copyOfRange(toBeSorted, midIndex, toBeSorted.length)));
	}
	
	private int[] merge(int[] firstHalf, int[] secondHalf) {
		int[] sorted = new int[firstHalf.length + secondHalf.length];
		
		int sortedIndex = 0;
		int firstHalfIndex = 0;
		int secondHalfIndex = 0;
		
		while (sortedIndex < sorted.length) {
			if (firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
				if (firstHalf[firstHalfIndex] <= secondHalf[secondHalfIndex]) {
					sorted[sortedIndex++] = firstHalf[firstHalfIndex++];
				}
				else {
					sorted[sortedIndex++] = secondHalf[secondHalfIndex++];
				}
			}
			else if (firstHalfIndex < firstHalf.length && secondHalfIndex >= secondHalf.length) {
				// copy the first half to sorted
				sorted[sortedIndex++] = firstHalf[firstHalfIndex++];
			}
			else if (secondHalfIndex < secondHalf.length && firstHalfIndex >= firstHalf.length) {
				// copy the second half to sorted
				sorted[sortedIndex++] = secondHalf[secondHalfIndex++];
			}
		}
		
		return sorted;
	}
	
	public static void main(String args[]) {
		
		Solution1 ms = new Solution1();
		
		int[] array1 = {3,2};
		System.out.println(Arrays.toString(ms.sort(array1)));
		
		int[] array2 = {1,5,3};
		System.out.println(Arrays.toString(ms.sort(array2)));
		
		int[] array3 = {3,5,1,3};
		System.out.println(Arrays.toString(ms.sort(array3)));
		
		int[] array4 = {5,3,8,1,2};
		System.out.println(Arrays.toString(ms.sort(array4)));
		
		int[] array5 = {5,7,9,2,5,3,7,2,10,8,6,11,4};
		System.out.println(Arrays.toString(ms.sort(array5)));
	}
}
