package Recursion;

/**
 * Rewrite for-loop in a recursive manner.
 * 
 * @author javanese-javanerd
 */
public class Practice1 {
	
	public static void func1(int N) {
		for (int i=1; i<N; i++) {
			System.out.println(i);
		}
	}
	
	public static void func2(int N) {
		if (N <= 1) {
			return;
		}
		else {
			func2(--N);
			System.out.println(N);
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Double for-loop");
		func1(5);
		System.out.println("\nRecursive loop");
		func2(5);
	}

}