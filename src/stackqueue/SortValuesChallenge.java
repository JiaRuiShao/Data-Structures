package stackqueue;

import java.util.Stack;

public class SortValuesChallenge {

    /**
     * Time: O(n^2)
     * Explanation: in order to get and make sure the first num is in the right position, O(n) time;
     * the 2nd number is gonna take O(n-1) time, ... the last number takes O(1) time.
     * Total time = O(n) + O(n-1) + ...+O(1) = O(n*(n+1)/2) = O(n^2)
     * Space: O(n)
     *
     * @param stack the unsorted stack
     */
    public static void sortStackDesc(Stack<Integer> stack) {
        if (stack == null || stack.size() == 0) {
            return;
        }
        Stack<Integer> tempStack = new Stack<>();
        int num = 0, max, finished = 0, size = stack.size();
        while (finished < size) {
            max = Integer.MIN_VALUE;
            // find the global min among the #(size - finished) elements
            while (!stack.isEmpty()) {
                num = stack.pop();
                max = Math.max(num, max);
                tempStack.push(num);
            }
            // add the elements back to stack1 if it's not the max
            while (tempStack.size() > finished) {
                num = tempStack.pop();
                if (num != max) {
                    stack.push(num);
                }
            }
            tempStack.push(max);
            finished++;
        }
        // tempStack is in descending order
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        // the stack now is in ascending order -> when we pop elements, it's gonna be descending order
    }

    public static void sortStackAsc(Stack<Integer> stack) {
        if (stack == null || stack.size() == 0) {
            return;
        }
        Stack<Integer> tempStack = new Stack<>();
        int num = 0, min, finished = 0, size = stack.size();
        while (finished < size) {
            min = Integer.MAX_VALUE;
            // find the global min among the #(size - finished) elements
            while (!stack.isEmpty()) {
                num = stack.pop();
                min = Math.min(num, min);
                tempStack.push(num);
            }
            // add the elements back to stack1 if it's not the min
            while (tempStack.size() > finished) {
                num = tempStack.pop();
                if (num != min) {
                    stack.push(num);
                }
            }
            tempStack.push(min);
            finished++;
        }
        // tempStack is in ascending order
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        // the stack now is in descending order -> when we pop elements, it's gonna be ascending order
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
        sortStackAsc(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
