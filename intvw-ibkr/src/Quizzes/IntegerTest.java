package Quizzes;

public class IntegerTest {
	public static void main(String[] args) {
		int a = 1;		// a = 1
		int b = a++;		// b = 1, then a is increased by 1
		int c = ++b;		// b is increased by 1 before setting its value to c
		System.out.println(a + " " + b + " " + c);
		
		// binary shift operator: <<
		int d = 1 << 2; 	// binary value of 1 (001) is shifted 2 times to the left (100); making it to be 4 (hex)
		System.out.println(d);
		
		// https://stackoverflow.com/questions/10358583/adding-char-and-int
		char SEPARATOR = 0x20;		// unicode character for space; its int value is 32.
		int MESSAGE_TYPE = 1;
		System.out.println( SEPARATOR + MESSAGE_TYPE + "=A");
	}

}
