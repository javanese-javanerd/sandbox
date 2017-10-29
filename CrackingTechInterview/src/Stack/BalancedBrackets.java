package Stack;

import java.util.Stack;

/**
A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:
.: It contains no unmatched brackets.
.: The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.

Assumptions:
1. Empty string won't be passed into the method.

Runtime complexity: O(n) because we may have to traverse throughout the whole string if it's a balanced brackets.
Space complexity: O(n) 
	.: In average, we'll create a stack with the size of n/2. 
	.: At worst, we have to create a stack with a size of n when string contains only opening brackets
	
 * @author javanese-javanerd
 */
public class BalancedBrackets {

	public static boolean isBalanced(String expression) {
		if (expression.length() == 1) return false;
		
		boolean isBalanced = false;
	    Stack<Character> stack = new Stack<Character>();
        for (int index=0; index<expression.length(); index++){
            if ('{' == expression.charAt(index)){
                stack.push('{');
            }
            else if ('(' == expression.charAt(index)){
                stack.push('(');
            } 
            else if ('[' == expression.charAt(index)){
                stack.push('[');
            }
            else {
            		if (!stack.isEmpty()) {
            			if ('}' == expression.charAt(index)){
		                char opener = stack.pop();
		                if ('{' != opener) return false;
            			}
            			else if (')' == expression.charAt(index)){
						char opener = stack.pop();
						if ('(' != opener) return false;
            			}
            			if (']' == expression.charAt(index)){
            				char opener = stack.pop();
        	                if ('[' != opener) return false;
            			}
            		}
            		else return false;
            }
        }
        
        if (stack.isEmpty()) isBalanced = true;
        
        return isBalanced;
    }
	
	public static void main(String args[]) {
		System.out.println("{ is balanced? " + isBalanced("{"));
		System.out.println("{[()]} is balanced? " + isBalanced("{[()]}"));
		System.out.println("{[(])} is balanced? " + isBalanced("{[(])}"));
		System.out.println("{{[[(())]]}} is balanced? " + isBalanced("{{[[(())]]}}"));
		System.out.println("{[()] is balanced? " + isBalanced("{[()]"));
		System.out.println(") is balanced? " + isBalanced(")"));
	}
}
