/*
* In the infix expression (the usual convention followed in mathematics),
* operators like + and * appear between the operands involved in the calculation:
*       6 + 3 * 8 - 4
* Another convention is the postfix expression,
* where the operators appear after the operands involved in the expression.
* In postfix, the expression written above will become:
*       6 3 8 * + 4 -
* */

package stackqueue;
import java.util.Stack;

class EvaluatePostfixChallenge {

    /**
     * Steps:
     * 1.Scan expression character by character,
     * 2.If character is a number push it in stack
     * 3.If character is operator then pop two elements from stack
     *    perform the operation and put the result back in stack
     * 4.At the end, Stack will contain result of whole expression.
     *
     * @param expression the post-fix expression input
     * @return the result of the post-fix expression
     */
    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (!Character.isDigit(character)) {
                Integer y = stack.pop();
                Integer x = stack.pop();

                switch (character) {
                    case '+':
                        stack.push(x + y);
                        break;
                    case '-':
                        stack.push(x - y);
                        break;
                    case '*':
                        stack.push(x * y);
                        break;
                    case '/':
                        stack.push(x / y);
                        break;
                    default:
                        break;
                }
            } else
                stack.push(Character.getNumericValue(character));
        }
        return stack.pop();
    }

    public static void main(String args[]) {
        System.out.println(evaluatePostFix("921*-8-4+"));
        System.out.println(evaluatePostFix("0123*-/8+"));
    }

}
