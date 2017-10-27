package Recursion;

/**
Given the following nested for loop:

	for(int a = INIT_A; CONDITION_A; P-EXPRESSION_A) {
	  CODE_A
	  for(int b = INIT_B; CONDITION_B; P-EXPRESSION_B) {
	    CODE_B
	    //^- if you use a in this you have to pass a as a parameter
	    for(int c = INIT_C; CONDITION_C; P-EXPRESSION_C) {
	      CODE_C
	      //^- same deal
	    }
	  }
	}

It'll become the following recursive calls:
	
	f(INIT_A)
	
	function f(int a) {
	  if(CONDITION_A) {
	    CODE_A
	    g(a, INIT_B);
	    P-EXPRESSION_A
	    f(a);
	  }
	}
	
	function g(int a, int b) {
	  if(CONDITION_B) {
	    CODE_B
	    h(a,b, INIT_C);
	    P-EXPRESSION_B
	    g(a, b);
	  }
	}
	
	function h(int a, int b, int c) {
	  if(CONDITION_C) {
	    CODE_C
	    P-EXPRESSION_C
	    h(a,b,c);
	  }
	}

 * @author javanese-javanerd
 */
public class Practice2 {

	public static void func1(int N) {
		for (int i=1; i<N; i++) {
			for (int j=i; j<N; j++) {
				System.out.println(i + "," + j);
			}
		}
	}
	
	public static void func2(int N) {
		helper1(1, N);
	}
	
	private static void helper1(int i, int N) {
		if (i < N){
			helper2(i, i, N);
			i++;
			helper1(i, N);
		}
	}
	
	private static void helper2(int i, int j, int N) {
		if (j < N) {
			System.out.println(i + "," + j);
			j++;
			helper2(i, j, N);
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Double for-loop");
		func1(5);
		System.out.println("\nRecursive loop");
		func2(5);
	}
}
