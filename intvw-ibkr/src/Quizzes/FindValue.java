package Quizzes;

public class FindValue {
	
	/**
	 * Which will be printed?
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
			if (b == 0x90) {
				System.out.print("We found it");
			}
		}
		System.out.println("We can't find it because 0x99 (" + 0x99 + ") is greater than Byte's MAX_VALUE (" + Byte.MAX_VALUE + ").");
	}
}
