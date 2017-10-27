package Recursion;

/**
 * Asked in tech interview with Bloomberg.
 * 
 * Given func1, rewrite the loop in a recursive way.
 * 
 * @author javenese-javanerd
 */
public class Practice3 {
	
	// assume n=5
	// OUTPUT:
	// 1,5  1,4  1,3  1,2
	// 2,5  2,4  2,3
	// 3,5  3,4
	// 4,5
	public static void func1(int N) {
		for (int i = 1; i < N; i++)
		    for (int j = N; j > i; j--)
		        System.out.println(i + "," + j);
	}     
	

	// rewrite func1 in recursive function
	public static void func2(int N){
		helper1(1, N);
	}
	
	private static void helper1(int i, int N){
		if (i<N) {
			helper2(i, N);
			i++;
			helper1(i, N);
		}
	}
	
	private static void helper2(int i, int j) {
		if (j>i) {
			System.out.println(i + "," + j);
			j--;
			helper2(i, j);
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Double for-loop");
		func1(5);
		System.out.println("\nRecursive loop");
		func2(5);
	}

}
