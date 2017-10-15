package String;

/**
 * A classic programming problem where the goal is to reverse a string.
 * 
 * Assumptions:
 * 1. input is a string that can be empty or null
 * 2. can't use any external library (such as StringUtils' reverse() or reverseDelimeter()
 * 
 * @author javanese-javanerd
 */
public class ReverseString {

	private static String reverse(String input) {
		if (null == input || input.length() == 0) {
			return null;
		}
		
		if (input.length() == 1) return input;
		
		int head = 0;
		int tail = input.length()-1;
		char[] inputArray = input.toCharArray();
		while (head < tail) {
			char tmp = inputArray[head];
			inputArray[head] = inputArray[tail];
			inputArray[tail] = tmp;
			head++;
			tail--;
		}
		
		return String.valueOf(inputArray);
	}
	
	public static void main(String args[]) {
		System.out.println("something");
		System.out.println(reverse("something"));
		System.out.println("Longer sentence to make it more interesting");
		System.out.println(reverse("Longer sentence to make it more interesting"));
	}
}
