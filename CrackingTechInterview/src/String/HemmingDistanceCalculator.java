package String;

/**
 * Hemming distance of a two equal size strings is defined as the number of character differences in those two strings.
 * For example: the following two strings have hemming distance of 2 because there are two characters at the same position that are different.
 * 	10035
 * 	10234
 * 	  d d
 * 
 * @author javanese-javanerd
 */
public class HemmingDistanceCalculator {
	
	public static int hemmingDistance(String s1, String s2) {
		if (null == s1 || null == s2 || s1.isEmpty() || s2.isEmpty()) return 0;
		if (s1.length() != s2.length()) return 0;
		
		int distance = 0;
		for (int i=0; i<s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				distance++;
		}
		
		return distance;
	}
	
	public static int hemmingDistance(int i1, int i2) {
		String s1 = Integer.toBinaryString(i1);
		String s2 = Integer.toBinaryString(i2);
		return hemmingDistance(s1, s2);
	}
	
	public static void main(String[] args) {
		System.out.println(hemmingDistance("abc123", "acc143"));
		System.out.println(hemmingDistance(10, 8));
	}
}
