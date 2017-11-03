package Array;

import java.util.Arrays;

public class ArrayModifier {

	public static void swap(int[] arr) {
		int tmp = arr[0];
		arr[0] = arr[arr.length-1];
		arr[arr.length-1] = tmp;
	}
	
	public static void replace(int[] arr) {
		int[] newArr = {8,1};
		arr = newArr;
	}
	
	public static int[] newArr() {
		int[] newArr = {8,1};
		return newArr;
	}
	public static void main(String[] args) {
		int[] arr = {2,1};
		
		System.out.println("Before swap: " + Arrays.toString(arr));
		swap(arr);
		System.out.println("After swap: " + Arrays.toString(arr));
		replace(arr);
		System.out.println("After replace: " + Arrays.toString(arr));
		arr = newArr();
		System.out.println("After newArr: " + Arrays.toString(arr));
	}
}
