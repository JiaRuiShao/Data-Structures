/*
* In this problem, you have to implement findCelebrity() method to find the celebrity
* in a party (matrix) using a stack. A celebrity is someone that everyone knows,
* but he/she doesn’t know anyone at the party.
*
* In the party matrix, a particular [row][col] stores acquaintance information for row and col. In other words,
* if [row][col] == 1, then it means row knows col, and if it’s zero, then it means row doesn’t know col.
* Remember that everyone knows a celebrity, but the celebrity doesn’t know the people at the party.
*
* Return - 1 if there is no celebrity in the party.
* Otherwise, return the ID or number of celebrities from the party matrix.
*
* */

package stackqueue;

import java.util.Stack;

public class FindCelebrity {

    /**
     * Time: O(n) where n is the length of the party (num of ppl)
     * Space: O(n)
     *
     * @param party the given arr index
     * @return the celebrity
     */
    public static int findCelebrity(int[][] party) {
        // corner case
        if (party == null || party.length == 0) {
            return -1;
        }

        int celebrity = -1, numPeople = party.length, first = 0, second = 0;
        Stack<Integer> candidate = new Stack<>();

        // pop all candidates into teh stack
        for (int i = 0; i < numPeople; i++) {
            candidate.push(i);
        }

        while (!candidate.isEmpty()) {
            first = candidate.pop();
            if (candidate.isEmpty()) {
                celebrity = first;
                break;
            }
            second = candidate.pop();
            // first candidate doesn't know the second candidate, disqualify the second candidate
            if (party[first][second] == 0) {
                candidate.push(first);
            } else { // first candidate knows second candidate, disqualify first candidate
                candidate.push(second);
            }
        }

        // check whether the last one in the stack satisfy the celebrity's requirements
        for (int i = 0; i < numPeople; i++) {
            if (i != celebrity && (party[i][celebrity] == 0 || party[celebrity][i] == 1)) { // disqualify the celebrity
                return -1;
            }
        }

        return celebrity;
    }

    public static void main(String args[]) {

        int [][] party1 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,0},
                {0,1,1,0},
        };

        int [][] party2 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,1},
                {0,1,1,0},
        };

        int [][] party3 = {
                {0,0,0,0},
                {1,0,0,1},
                {1,0,0,1},
                {1,1,1,0},
        };

        System.out.println(findCelebrity(party1));
        System.out.println(findCelebrity(party2));
        System.out.println(findCelebrity(party3));
    }
}
