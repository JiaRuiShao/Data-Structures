package graph;

import java.util.*;

public class AllTaskSchedulingOrders {
    public static void printOrders(int courseNum, int[][] prerequisites) {
        // 0 - corner cases
        if (courseNum < 1 || prerequisites == null || prerequisites.length == 0) {
            return;
        }
        // 1 - initialize the graph
        // store the course that is a pre-requisite as the key and the courses that requires it
        Map<Integer, List<Integer>> isPrerequisite = new HashMap<>();
        // store the num of pre-requisite courses this course needs
        Map<Integer, Integer> needPrerequisite = new HashMap<>();
        Queue<Integer> preClearedCourses = new LinkedList<>();
        int tempCourse;

        for (int i = 0; i < courseNum; i++) {
            isPrerequisite.put(i, new ArrayList<>());
            needPrerequisite.put(i, 0);
        }

        // 2 - build the graph
        for (int[] prerequisite : prerequisites) {
            isPrerequisite.get(prerequisite[0]).add(prerequisite[1]);
            needPrerequisite.put(prerequisite[1], needPrerequisite.get(prerequisite[1]) + 1);
        }

        // 3 - find the courses that doesn't need any pre-requisite course
        for (Map.Entry<Integer, Integer> entry : needPrerequisite.entrySet()) {
            if (entry.getValue() == 0) {
                preClearedCourses.offer(entry.getKey());
            }
        }

        printCourses(new LinkedList<>(), isPrerequisite, needPrerequisite, preClearedCourses, courseNum);
    }

    /**
     * A private helper function to print all the possible ordering of the courses.
     * Time: O(V! * E)
     * Space: O(V!)
     *
     * @param result the list to store the added courses
     * @param isPrerequisite the map tp store the courses and the list of courses that require this course as a prerequisite
     * @param needPrerequisite the courses and the num of prerequisite courses this course needs
     * @param preClearedCourses the queue that store the courses that doesn't need a prerequisite or its prerequisites are satisfied
     * @param courseNum the num of courses in the given input
     */
    private static void printCourses(List<Integer> result , Map<Integer, List<Integer>> isPrerequisite, Map<Integer, Integer> needPrerequisite, Queue<Integer> preClearedCourses, int courseNum) {
        // base case
        if (result.size() == courseNum) {
            System.out.println(result);
            return;
        }
        if (preClearedCourses.isEmpty()) {
            return;
        }

        // recursive rules
        for (int course : preClearedCourses) { // O(V)
            // get the course and add it to the result
            result.add(course);
            // prepare preClearedCourses for the next stack
            Queue<Integer> next = new LinkedList<>(preClearedCourses);
            next.remove(course);
            // update the num of prerequisites for the course who require this course as a prerequisite
            for (int c : isPrerequisite.get(course)) { // O(E) * O(V)
                needPrerequisite.put(c, needPrerequisite.get(c) - 1);
                if (needPrerequisite.get(c) == 0) {
                    next.offer(c);
                }
            }
            printCourses(result, isPrerequisite, needPrerequisite, next, courseNum);
            // backtrack, remove the course from the result and increase the num of prerequisite fot the courses that
            // require this course
            result.remove((Integer) course); // remove the object instead of the index
            for (int c : isPrerequisite.get(course)) {
                needPrerequisite.put(c, needPrerequisite.get(c) + 1);
            }
        }
    }

    public static void main(String[] args) {
       /* AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();*/

        AllTaskSchedulingOrders.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }
}
