package stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    /**
     * Time: O(1)
     * @param value the value to add
     */
    public void push(int value) {
        q1.offer(value);
    }

    /**
     * Time: Amortized O(1)
     * O(1) + O(n)[while condition] + O(2(n-1)) [offer and poll inside 1st while] + O(1) +
     * O(n) [2nd while condition] + O(2(n-1)) [offer and poll inside 2nd while] = O(6n-2)
     * Thus, the amortized time = O(6n-2)/n = O(6) = O(1)
     *
     * @return the value got popped
     */
    public int pop() {
        // if the stack is empty
        if (q1.isEmpty()) {
            return -1;
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        } // terminate when q1 is empty

        int temp = q1.poll();

        // put all the other elements back
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return temp;
    }

    public static void main(String[] args) {
        StackUsingQueue myStack = new StackUsingQueue();
        System.out.println(myStack.pop());
        myStack.push(3);
        myStack.push(5);
        myStack.push(9);
        System.out.println(myStack.pop());
        myStack.push(10);
        myStack.push(16);
        System.out.println(myStack.pop());
    }
}
