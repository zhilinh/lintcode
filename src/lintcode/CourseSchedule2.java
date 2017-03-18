package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        /**
         * Edge case.
         */
        if (numCourses == 0) {
            return new int[0];
        }
        /**
         * Number of prerequisites.
         */
        int numPre = prerequisites.length;
        /**
         * Final order.
         */
        int[] result = new int[numCourses];
        /**
         * How many courses a course has as prerequisites.
         */
        int[] degree = new int[numCourses];
        /**
         * Lists of prerequisites courses.
         */
        List<Integer>[] edges = new ArrayList[numCourses];
        /**
         * Courses without a prerequisite.
         */
        Queue<Integer> order = new LinkedList<Integer>();
        /**
         * Final queue.
         */
        Queue<Integer> queue = new LinkedList<Integer>();
        /**
         * Initialization of prerequisites courses list.
         */
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < numPre; i++) {
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
            // Loop!
            degree[prerequisites[i][0]]++;
        }
        /**
         * Find all courses without a prerequisite and put them in a queue.
         */
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                order.offer(i);
            }
        }
        /**
         * When the queue with no-prerequisites courses is not empty,
         * put them into the final queue like finished
         * and find rest of courses without a prerequisite.
         */
        int count = 0;  // Count the number of courses into the queue.
        while (!order.isEmpty()) {
            int num = order.poll();
            count++;
            queue.offer(num);
            for (int i = 0; i < edges[num].size(); i++) {
                degree[edges[num].get(i)]--;
                if (degree[edges[num].get(i)] == 0) {
                    order.offer(edges[num].get(i));
                }
            }
        }
        /**
         * If count is not equal to the number of courses,
         * it represents that there is a graph in the topological sort.
         */
        if (count != numCourses) {
            return new int[0];
        }
        /**
         * Put all courses from the final queue into the integer array
         */
        int i = 0;
        while (!queue.isEmpty()) {
            result[i] = queue.poll();
            i++;
        }
        return result;
    }
}
