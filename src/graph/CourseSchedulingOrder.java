package graph;

import java.util.*;

/**
 * There are ‘N’ courses, labeled from ‘0’ to ‘N-1’. Each course has some prerequisite courses
 * which need to be completed before it can be taken. Given the number of courses
 * and a list of prerequisite pairs, write a method to find the best ordering
 * of the courses that a student can take in order to finish all courses.
 *
 * Similar to TopologicalSort.
 */
public class CourseSchedulingOrder {

    /**
     * Time: O(3V + 2E) = O(V + E)
     * Space: O(3V + E) = O(V + E)
     *
     * @param courseNum the num of courses
     * @param prerequisites prerequisite[0] is a prerequisite of prerequisite[1]
     * @return one possible order of courses so that all pre-requisite courses
     * are taken before the courses that require them
     */
    public static List<Integer> findOrder(int courseNum, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        // 0 - corner cases
        if (courseNum < 1 || prerequisites == null || prerequisites.length == 0) {
            return result;
        }
        // 1 - initialize the graph
        // store the course that is a pre-requisite as the key and the courses that requires it
        Map<Integer, List<Integer>> isPrerequisite = new HashMap<>();
        // store the num of pre-requisite courses this course needs
        Map<Integer, Integer> needPrerequisite = new HashMap<>();
        Queue<Integer> noNeedPreCourses = new LinkedList<>();
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
                noNeedPreCourses.offer(entry.getKey());
            }
        }

        // 4 - update the isPrerequisite hashmap & find new sources
        while (!noNeedPreCourses.isEmpty()) {
            tempCourse = noNeedPreCourses.poll();
            result.add(tempCourse);
            for (int course : isPrerequisite.get(tempCourse)) {
                // for the courses that require this tempCourse as a pre-requisite,
                // reduce the num of their pre-requisite courses
                // if the num becomes zero, AKA they have no other pre-requisite courses,
                // add them into the queue
                needPrerequisite.put(course, needPrerequisite.get(course) - 1);
                if (needPrerequisite.get(course) == 0) {
                    noNeedPreCourses.offer(course);
                }
            }
        }

        // 5 - return if there's cycle (conflicts) in prerequisites
        if (result.size() != courseNum) {
            return new ArrayList<>();
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = CourseSchedulingOrder.findOrder(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        System.out.println(result);

        result = CourseSchedulingOrder.findOrder(3,
                new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}});
        System.out.println(result);

        result = CourseSchedulingOrder.findOrder(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
        System.out.println(result);
    }
}
