package Quizzes;

public class IntegerTest {
	public static void main(String[] args) {
		int a = 1;
		int b = a++;
		int c = ++b;
		System.out.println(a + " " + b + " " + c);
		
		int d = 1 << 2; 
		System.out.println(d);
		
		final char SEPARATOR = 0x20;
		final int MESSAGE_TYPE = 1;
		System.out.println(SEPARATOR + MESSAGE_TYPE + "=A");
	}

}
