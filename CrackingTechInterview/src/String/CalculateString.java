package String;

/*
You are building an educational website and want to create a simple calculator for students to use. 
For now, the calculator will only allow addition and subtraction of positive integers.

Given an expression string using the "+" and "-" operators like "5+16-2", write a function to parse the string and evaluate the result.

Sample input/output:
"6+9-12" => 3
"1+2-3+4-5+6-7" => -2

Assumptions:
1. No special chars other than + or -
2. Only positive integers
3. No space in between characters

*/
import java.util.*;

public class CalculateString {
	public static void main(String[] args) {
		String expression = "6+9-12";
		System.out.println(expression + " = " + expressionReader(expression));

		expression = "1+2-3+4-5+6-7";
		System.out.println(expression + " = " + expressionReader(expression));
	}

	public static String expressionReader(String expression) {
		List<String> input = convert(expression);

		int result = Integer.parseInt(input.get(0));
		int numberIndex = 2;
		int operatorIndex = 1;
		while (numberIndex < input.size()) {
			result = performOperation(result, input.get(numberIndex), input.get(operatorIndex));

			numberIndex += 2;
			operatorIndex += 2;
		}

		return "" + result;
	}

	private static List<String> convert(String expression) {
		List<String> input = new ArrayList<String>();

		String number = "";
		String operator = "";

		for (int index = 0; index < expression.length(); index++) {
			operator = "";
			char tmp = expression.charAt(index);
			try {
				int num = Integer.parseInt("" + tmp);
				number += num;
			} catch (Exception e) {
				operator += tmp;
				input.add(number);
				input.add(operator);
				number = "";
			}
		}

		// add the last number into list
		input.add(number);
		return input;
	}

	private static int performOperation(int result, String number, String operator) {
		int num = Integer.parseInt(number);

		if ("+".equals(operator)) {
			result += num;
		} else {
			result -= num;
		}

		return result;
	}

}
