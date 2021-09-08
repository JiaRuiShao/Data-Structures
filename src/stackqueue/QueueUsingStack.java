/*
* Implement a queue using stacks.*
* */

package stackqueue;

import java.util.Stack;

public class QueueUsingStack {

    public Stack<Integer> s1 = new Stack<>();
    public Stack<Integer> s2 = new Stack<>();

    /**
     * Time: O(1)
     * @param value the value to be offered
     */
    public void offer(int value) {
        s1.push(value);
    }

    /**
     * Time: amortized O(1)
     *
     * Explanation:
     * Say there is n elements in stack 1 when we call queue.poll()
     * the overall time is: O(3) [check s1 & s2 empty] + O(2n) [check empty n times & pop all from s1] + O(n) [push all into s2]
     * + O(1) [pop the first element from s2] = O(3n+1)
     *
     * The amortized time = O(3n+4)/(n+1) = O(1)
     *
     * @return the value polled
     */
    public int poll() {
        // corner case -- no elements to poll
        if (s1.isEmpty() && s2.isEmpty()) {
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStack myQueue = new QueueUsingStack();
        System.out.println(myQueue.poll());
        myQueue.offer(3);
        myQueue.offer(6);
        myQueue.offer(16);
        System.out.println(myQueue.poll());
        myQueue.offer(8);
        myQueue.offer(4);
        System.out.println(myQueue.poll());
    }
}
