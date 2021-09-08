package stackqueue;

import java.util.*;

public class ReverseKChallenge {

    /**
     * Time: O(n)
     * Space: O(k)
     *
     * @param queue
     * @param k
     * @param <V>
     */
    public static <V> void reverseK(Queue<V> queue, int k) {
        Stack<V> s = new Stack<>(); // size = k
        int size = queue.size();

        if (k <= 1 || k > size) {
            return;
        }

        // put these k elements need to be reversed into a stack
        for (int i = 0; i < k; i++) {
            s.push(queue.poll());
        }
        // offer them back into the queue
        while(!s.isEmpty()) {
            queue.offer(s.pop());
        }
        // poll and offer (size - k) times to make sure the order is correct
        for (int i = 0; i < size - k; i++) {
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        queue.offer(8);
        queue.offer(9);
        queue.offer(10);

        reverseK(queue,5);

        System.out.print("Queue: ");
        while(!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
