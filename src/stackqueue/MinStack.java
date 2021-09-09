/*
* Create Stack where min() gives minimum in O(1) time and space complexity.
* */

package stackqueue;

import java.util.Stack;

/**
 * Note that we could use another stack to keep track of and store the minimum number.
 * However, the space complexity is O(n), which is worse than just storing the min in this way.
 */
public class MinStack {
    int maxSize;
    int globalMin;
    Stack<Integer> stack;

    public MinStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new Stack<>();
    }

    public Integer pop(){
        if (stack.size() == 0) {
            return null;
        }
        int num = 0;
        if (stack.peek() < globalMin) {
            num = globalMin; // store the current min --> the original number
            globalMin = 2 * globalMin - stack.pop(); // 2 * (currMin-originalNum) - valueStoredInStack ==> prevMin
        } else {
            num = stack.pop();
        }
        return num;
    }

    public void push(Integer value){
        if (stack.size() == maxSize) {
            return;
        }

        if (stack.isEmpty()) {
            globalMin = value;
            stack.push(value);
            return;
        }

        // 2 * (originalNum=currMin) - prevMin ==> numStoredInStack
        if (value < globalMin) {
            stack.push(2 * value - globalMin);
            globalMin = value;
        } else {
            stack.push(value);
        }
    }

    public int getMin(){
        return globalMin;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack(6);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(9);

        System.out.println(stack.getMin());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.getMin());
    }
}

