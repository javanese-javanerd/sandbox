package String;

/**
 * Simple utility method to convert a number into its binary values.
 * 
 * @author javanese-javanerd
 */
public class BinaryCalculator {

	public static long calculate(String s1, String s2) {
		long value1 = convertToDecimal(s1);
		long value2 = convertToDecimal(s2);
		
		return value1 + value2;
	}
	
	private static long convertToDecimal(String s) {
		long retVal = 0;
		
		for (int i = s.length()-1, p = 0; i >= 0; i--, p++) {
			int val = Integer.valueOf("" + s.charAt(i));
			retVal += val * (Math.pow(2, p));
		}
		
		return retVal;
	}
	
	public static void main(String[] args) {
		System.out.println(calculate("0111", "1111"));
		System.out.println(calculate("01111111", "01111111"));
	}
	
}
