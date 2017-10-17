package Question5;

public class Conversion {
	/**
	 * Convert a base-10 integer to an 8-bit two's complement binary number, and  return the binary number.
	 * 
	 * Assumptions:
	 * 1. Since 8 bit can only hold value between -1 and 127 (in decimal), I'll impose this restriction in the input. 
	 * 
	 */
	public String base10to2(String base10) {
		StringBuffer retVal = new StringBuffer();
		if (validBase10Integer(base10)) {
			retVal.append(padLeft(Integer.toBinaryString(Integer.valueOf(base10))));
		}
		else {
			retVal.append("INVALID");
		}
		
		return retVal.toString();
	}
	
	/**
	 * Return 2's complement negative of the given base10 number and return the binary number
	 * 
	 * Assumptions:
	 * 1. I'm still going to limit to 8 bit.
	 * 2. Input value will be of a negative value.
	 * 3. Since 8 bit can only hold negative value up to -128, I'll impose this restriction in the input.
	 */
	public String negBase2(String base10) {
		StringBuffer retVal = new StringBuffer();
		if (validBase10NegativeInteger(base10)) {
			retVal.append(padRight(Integer.toBinaryString(Integer.parseInt(base10))));
		}
		else {
			retVal.append("INVALID");
		}
		
		return retVal.toString();
	}
	
	private boolean validBase10Integer(String base10) {
		Integer value = null;
		try {
			value = Integer.valueOf(base10);
			if (value >= -1 && value <= 127)
				return true;
		}
		catch(Exception e) {
			// do nothing
		}
		
		return false;
	}
	
	private boolean validBase10NegativeInteger(String base10) {
		Integer value = null;
		try {
			value = Integer.valueOf(base10);
			if (value >= -128 && value < 0)
				return true;
		}
		catch(Exception e) {
			// do nothing
		}
		
		return false;
	}
	
	private String padLeft(String str) {
		if (str.length() == 8) return str.toString();
		if (str.length() > 8) return str.substring(0, 8);
		
		// bit length must be less than 8 character in length 
		StringBuffer retVal = new StringBuffer();
		for (int i=0; i<8-str.length(); i++) {
			retVal.append("0");
		}
		retVal.append(str);
		
		return retVal.toString();
	}
	
	private String padRight(String str) {
		if (str.length() == 8) return str.toString();
		if (str.length() > 8) return str.substring(str.length()-8, str.length());
		
		// bit length must be less than 8 character in length 
		StringBuffer retVal = new StringBuffer();
		retVal.append(str);
		for (int i=0; i<8-str.length(); i++) {
			retVal.append("0");
		}
		
		return retVal.toString();
	}
	
	public static void main(String args[]) {
		Conversion c = new Conversion();
		System.out.println("-1\t" + c.base10to2("-1"));
		System.out.println("-2\t" + c.base10to2("-2"));
		System.out.println("-100\t" + c.base10to2("-100"));
		System.out.println("0\t" + c.base10to2("0"));
		System.out.println("119\t" + c.base10to2("119"));
		System.out.println("127\t" + c.base10to2("127"));
		System.out.println("128\t" + c.base10to2("128"));
		System.out.println("1000\t" + c.base10to2("1000"));
		System.out.println("319a\t" + c.base10to2("319a"));
		
		System.out.println("-128\t" + c.negBase2("-128"));
		System.out.println("-129\t" + c.negBase2("-129"));
		System.out.println("-1000\t" + c.negBase2("-1000"));
		System.out.println("-15\t" + c.negBase2("-15"));
		System.out.println("-1\t" + c.negBase2("-1"));
		System.out.println("0\t" + c.negBase2("0"));
		System.out.println("128\t" + c.negBase2("128"));
		
	}
}
