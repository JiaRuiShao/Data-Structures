package stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CheckBinary {

    /**
     * Time: O(n)
     * Space: O(2n) - offer 2, poll 1
     *
     * @param n the number of binary numbers we want
     * @return the binary number String array
     */
    public static String[] findBin(int n) {
        String[] result = new String[n];
        Queue<String> q = new ArrayDeque<>();
        q.offer("1");

        for (int i = 0; i < n; i++) {
            result[i] = q.poll();
            q.offer(result[i] + "0");
            q.offer(result[i] + "1");
        }
        return result;
    }

    public static int getUserInput() {
        Scanner readInput = new Scanner(System.in);
        System.out.println("How many Binary Numbers do you want?");
        int n = readInput.nextInt();
        readInput.close();
        return n;
    }

    public static void main(String[] args) {
        int binaryNum = getUserInput();
        String[] output = findBin(binaryNum);
        for(int i = 0; i < binaryNum; i++) {
            System.out.print(output[i] + " ");
        }
    }
}
