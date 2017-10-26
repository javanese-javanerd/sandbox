package coding.test;

import java.util.Arrays;

/**
 * Your boss has given you a task to write a method that sorts. You don't need a
 * normal sorting algorithm, though, where the results are in a simple ascending
 * or descending order - that would be too easy! Instead, you are told the
 * results of your "sort" must conform to a pattern... but no one is sure what
 * that pattern is. All you are provided with is a set of sample inputs and
 * results.
 * 
 * You must analyze the sample outputs and figure out the pattern that your
 * sorting method must be trying to achieve. Then design and implement an
 * algorithm that will accept an array of integers and produce a result that
 * will conform to that pattern.
 * 
 * 
 * Input: Integer[] array = {2, 4, 2, 2, 3, 4, 5, 3, 2, 2, 2} 
 * Result: array == {2, 4, 2, 3, 2, 5, 3, 4, 2, 2, 2}
 * 
 * Input: Integer[] array = {2, 2, 6, 0, 3, 4} 
 * Result: array == {2, 6, 0, 3, 2, 4}
 * 
 * Input: Integer[] array = {12, 8, 3, -7, 12, 14, -7, 14, 13, 19} 
 * Result: array == {8, 12, -7, 12, 3, 14, -7, 14, 13, 19}
 * 
 * Input: Integer[] array = {33, 80, 80, 61, 7, 91, 2, 89, 32, 28} 
 * Result: array == {33, 80, 61, 80, 7, 91, 2, 89, 28, 32}
 **/

class SlidingWindowSort {
	public static void main(String[] args) throws java.lang.Exception {
		Integer[] testArray = new Integer[] { 2, 4, 2, 2, 3, 4, 5, 3, 2, 2, 2 };
		sort(testArray);
		System.out.println(Arrays.toString(testArray));
	}

	public static void swap(Integer[] testArray, int first, int second) {
		Integer temp = testArray[first];
		testArray[first] = testArray[second];
		testArray[second] = temp;
	}

	public static void sort(Integer[] testArray) {
		// base case
		if (0 == testArray.length)
			return;

		int i = 0;
		int j = i + 1;
		boolean small = true;
		while (j < testArray.length) {
			if (small) {
				if (testArray[i] > testArray[j]) {
					swap(testArray, i, j);
				}
			} else {
				if (testArray[i] < testArray[j]) {
					swap(testArray, i, j);
				}
			}

			i += 1;
			j += 1;

			small = !small;
		}
	}
}
