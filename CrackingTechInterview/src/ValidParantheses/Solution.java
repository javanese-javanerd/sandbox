package ValidParantheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (null == s || s.length() == 0) return true;

        // push and pop as needed
        Stack content = new Stack();

        for (int index = 0; index < s.length(); index++) {
            if ('(' == s.charAt(index) || '{' == s.charAt(index) || '[' == s.charAt(index)) {
                content.push(s.charAt(index));
            }
            else if (s.charAt(index) == ')' || s.charAt(index) == '}' || s.charAt(index) == ']'){
                if (content.empty()) return false;

                char top = content.peek().toString().charAt(0);
                // attempt to pop regular bracket
                if (s.charAt(index) == ')'){
                    if (top == '('){
                        content.pop();
                    }
                    else return false;
                }
                else if (s.charAt(index) == '}'){
                    if (top == '{'){
                        content.pop();
                    }
                    else return false;
                }
                else if (s.charAt(index) == ']'){
                    if (top == '['){
                        content.pop();
                    }
                    else return false;
                }
            }
        }

        if (content.empty()) {
            return true;
        }

        return false;
    }
}
