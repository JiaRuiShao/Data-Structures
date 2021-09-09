/*
* In this problem, you have to implement the isBalanced() method, which will take a string
* containing only curly {}, square [], and round () parentheses.
* The method will tell us whether all the parentheses in the string are balanced or not.
*
* For all the parentheses to be balanced, every opening parenthesis must have a closing one.
* The order in which they appear, also matters. For example, {[]} is balanced, but {[}] is not.
*
* */

package stackqueue;

import java.util.Stack;

public class checkBalanced {

    private static boolean isClosedParenthesis(char stackTop, char nextInStr) {
        if (stackTop == '{' && nextInStr == '}') {
            return true;
        } else if (stackTop == '[' && nextInStr == ']') {
            return true;
        } else if (stackTop == '(' && nextInStr == ')') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Time: O(n)
     * Space: O(n)
     *
     * @param exp the input expression String
     * @return true if the input expression is balanced; false if not
     */
    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            if (stack.isEmpty() || !isClosedParenthesis(stack.peek(), exp.charAt(i))) {
                stack.push(exp.charAt(i));
            } else if (isClosedParenthesis(stack.peek(), exp.charAt(i))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("[{(}]"));
    }
}
