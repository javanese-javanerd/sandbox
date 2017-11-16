package String;

import java.util.Stack;

public class DigitSpeller {
	
	private final String[] SINGLE_DIGIT = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	private final String[] TEEN = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	
	private final String[] DOUBLE_DIGIT = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"}; 
	
	/**
	 * Returns the string representing a spell out version of a given number.
	 * 
	 * Limitation:
	 * .: number is a whole integer.
	 * .: 0 <= number < 100,000
	 * .: number cannot start with 0
	 * .: only positive
	 * .: no special character in number
	 * 
	 * @param number
	 * @return
	 */
	public String spell(String number) {
		// base case: if parameter is a single digit number
		if (number.length() == 1)
			return spellX(Integer.parseInt(number));

		Stack<String> spelledNumber = spellHelper(number);
		StringBuilder sb = new StringBuilder();
		while(!spelledNumber.isEmpty()) {
			String num = spelledNumber.pop();
			if (null != num && !num.isEmpty())
				sb.append(num).append(" ");
		}
		
		return sb.toString().trim();
	}
	
	private Stack<String> spellHelper(String number){
		Stack<String> spelledStack = new Stack<String>();getClass();
		
		int digitHelper = 1;
		int index = number.length() - 1;
		while (index >= 0) {
			int digit = Integer.parseInt("" + number.charAt(index));
			int companion;
			switch(digitHelper) {
				case 1:
					if (digit != 0) spelledStack.push(spellX(digit));
					break;
				case 2:
					companion = Integer.parseInt("" + number.charAt(index + 1));
					if (digit == 1 && !spelledStack.isEmpty()) spelledStack.pop();
					spelledStack.push(spellXX(digit, companion));
					break;
				case 3:
					spelledStack.push(spellXXX(digit));
					break;
				case 4: 
					spelledStack.push(spellXXXX(digit));
					break;
				case 5:
					companion = Integer.parseInt("" + number.charAt(index + 1));
					if (!spelledStack.isEmpty()) spelledStack.pop();
					spelledStack.push(spellXXXXX(digit, companion));
					break;
			}
			
			digitHelper++;
			index--;
		}
		
		return spelledStack;
	}
	
	private String spellX(int digit) {
		return SINGLE_DIGIT[digit];
	}
	
	private String spellXX(int xx, int x) {
		StringBuilder sb = new StringBuilder();

		if (xx == 1) {
			sb.append(TEEN[x]);
		}
		else {
			sb.append(DOUBLE_DIGIT[xx]);
		}
		
		return sb.toString();
	}
	
	private String spellXXX(int digit) {
		StringBuilder sb = new StringBuilder();
		if (digit != 0) {
			sb.append(spellX(digit)).append(" hundred");
		}
		
		return sb.toString();
	}
	
	private String spellXXXX(int digit) {
		StringBuilder sb = new StringBuilder();
		if (digit != 0) {
			sb.append(spellX(digit)).append(" thousand");
		}
		
		return sb.toString();
	}
	
	private String spellXXXXX(int digit, int companion) {
		StringBuilder sb = new StringBuilder();
		if (digit != 0) {
			sb.append(spellXX(digit, companion));
		}
		
		if (digit != 1 && companion != 0) {
			sb.append(" ").append(spellX(companion));
		}
		
		return sb.append(" thousand").toString();
	}
	
	public static void main(String[] args) {
		DigitSpeller speller = new DigitSpeller();
		System.out.println(speller.spell("0"));
		System.out.println(speller.spell("5"));
		System.out.println(speller.spell("10"));
		System.out.println(speller.spell("14"));
		System.out.println(speller.spell("16"));
		System.out.println(speller.spell("20"));
		System.out.println(speller.spell("21"));
		System.out.println(speller.spell("54"));
		System.out.println(speller.spell("99"));
		System.out.println(speller.spell("100"));
		System.out.println(speller.spell("108"));
		System.out.println(speller.spell("110"));
		System.out.println(speller.spell("115"));
		System.out.println(speller.spell("120"));
		System.out.println(speller.spell("357"));
		System.out.println(speller.spell("3000"));
		System.out.println(speller.spell("4004"));
		System.out.println(speller.spell("5015"));
		System.out.println(speller.spell("5030"));
		System.out.println(speller.spell("4055"));
		System.out.println(speller.spell("7298"));
		System.out.println(speller.spell("20000"));
		System.out.println(speller.spell("20002"));
		System.out.println(speller.spell("20050"));
		System.out.println(speller.spell("20072"));
		System.out.println(speller.spell("20500"));
		System.out.println(speller.spell("20503"));
		System.out.println(speller.spell("20580"));
		System.out.println(speller.spell("20589"));
		System.out.println(speller.spell("19589"));
		System.out.println(speller.spell("73589"));
		System.out.println(speller.spell("99999"));
	}
}
