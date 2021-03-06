package MergeSort;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {

	/**
	 * Sort array using merge-sort algorithm and count how many inversions it takes.
	 * 
	 * @param toBeSorted
	 * @return
	 */
	public static int swapCount(int[] toBeSorted) {
		if (null == toBeSorted || toBeSorted.length == 0 || toBeSorted.length == 1) return 0;
		
		return sortAndCount(toBeSorted, 0, toBeSorted.length -1);
	}
	
	private static int sortAndCount(int[] toBeSorted, int startIndex, int endIndex) {
		
		// recursively call this method as long as startIndex is smaller than endIndex.
		// we don't plan to sort anything here. 
		int counter = 0;
		if (startIndex < endIndex) {
			int midIndex = (startIndex + endIndex) / 2;
			counter += sortAndCount(toBeSorted, startIndex, midIndex);
			counter += sortAndCount(toBeSorted, midIndex + 1, endIndex);
			counter += merge(toBeSorted, startIndex, midIndex, endIndex);
		}
		
		return counter;
	}
	
	private static int merge(int[] toBeSorted, int startIndex, int midIndex, int endIndex) {
		int[] sorted = new int[endIndex-startIndex+1];
		int inversionCount = 0;
		
		int sortedIndex = 0;
		int index1 = startIndex;
		int index2 = midIndex + 1;
		
		while (sortedIndex < sorted.length) {
			if (index1 <= midIndex && index2 <= endIndex) {
				if (toBeSorted[index1] > toBeSorted[index2]) {
					sorted[sortedIndex++] = toBeSorted[index2++];
					inversionCount += midIndex - index1 + 1;
				}
				else {
					sorted[sortedIndex++] = toBeSorted[index1++];
				}
			}
			else if (index1 > midIndex && index2 <= endIndex) {
				sorted[sortedIndex++] = toBeSorted[index2++];
			}
			else if (index1 <= midIndex && index2 > endIndex) {
				sorted[sortedIndex++] = toBeSorted[index1++];
			}
			else {
				sortedIndex++;
			}
		}
		
		// copy back to toBeSorted
		for (int i=0, j=startIndex; i<sorted.length; i++, j++) {
			toBeSorted[j] = sorted[i];
		}
		
		return inversionCount;
	}
	
	public static void readFromTestFile(String filename) {
		int[] inputArray = null;
		FileInputStream fileInputStream = null;
		Scanner scanner = null;
		try {
			fileInputStream = new FileInputStream(filename);
			scanner = new Scanner(fileInputStream, "UTF-8");
			int arrSize = scanner.nextInt();
	        inputArray = new int[arrSize];
            for(int arr_i = 0; arr_i < arrSize; arr_i++){
                inputArray[arr_i] = scanner.nextInt();
            }
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			if (null != scanner) scanner.close();
			if (null != fileInputStream) {
				try {
					fileInputStream.close();
				}
				catch (IOException ioe) {}
			}
		}
		System.out.println("Count for " + filename + ": " + swapCount(inputArray));
		System.out.println("Input array sorted? " + isSorted(inputArray));
	}
	
	public static boolean isSorted(int[] arr) {
		for (int index = 1; index < arr.length; index++) {
			if (arr[index] < arr[index-1]) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] array00 = {};		// return 0
		int[] array01 = {5};		// return 0
		int[] array02 = {6,7};	// return 0
		int[] array1 = {3,2};	// return 1
		int[] array2 = {1,5,3};
		int[] array3 = {3,5,1,3};
		int[] array4 = {5,3,8,1,2};
		int[] array5 = {5,7,9,2,5,3,7,2,10,8,6,11,4};
		int[] array6 = {2,1,3,1,2};
		
		System.out.println(swapCount(null) + " : for null object.");
		System.out.println(swapCount(array00) + " : " + Arrays.toString(array00));
		System.out.println(swapCount(array01) + " : " + Arrays.toString(array01));
		System.out.println(swapCount(array02) + " : " + Arrays.toString(array02));
		System.out.println(swapCount(array1) + " : " + Arrays.toString(array1));
		System.out.println(swapCount(array2) + " : " + Arrays.toString(array2));
		System.out.println(swapCount(array3) + " : " + Arrays.toString(array3));
		System.out.println(swapCount(array4) + " : " + Arrays.toString(array4));
		System.out.println(swapCount(array5) + " : " + Arrays.toString(array5));
		System.out.println(swapCount(array6) + " : " + Arrays.toString(array6));
		
		readFromTestFile("./src/MergeSort/TestCase7_32688_0.txt");
		readFromTestFile("./src/MergeSort/TestCase7_65911_0.txt");
		readFromTestFile("./src/MergeSort/TestCase7_73099_0.txt");
		readFromTestFile("./src/MergeSort/TestCase7_100000_4999950000.txt");
	}
}
