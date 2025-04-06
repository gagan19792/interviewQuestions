package org.interview.questions.graph;


import java.util.*;

public class CourseSchedule {


    public static int[] topologicalSort(int numCourses, int[][] prerequisites){

        // Build the graph as an adjacency list and compute in-degrees for each node.
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        // Build the graph.
        // Each edge [a, b] means that to take course a, you must first take course b.
        // In the graph, add an edge from b to a.

        for(int[] edge: prerequisites){
            int course = edge[0];
            int prereq = edge[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Initialize a queue with all nodes having in-degree 0.
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< numCourses;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        // List to hold the topological order.
        int[] topoOrder = new int[numCourses];
        int index = 0;

        // Process nodes with in-degree 0.
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder[index++] = node;

            // For each neighbor, decrease its in-degree.
            for(int neighbor: graph.get(node)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] ==0){
                    queue.offer(neighbor);
                }
            }
        }

        // If not all nodes were processed, a cycle exists.
        if (index != numCourses) {
            return new int[0];
        }

        return topoOrder;

    }

    public static void main(String[] args) {
        CourseSchedule ts = new CourseSchedule();

        // Example: 4 courses with prerequisites: [1, 0], [2, 0], [3, 1], [3, 2]
        // Interpretation: To take course 1, you must first take course 0, etc.
        int numCourses = 4;
        int[][] prerequisites = { {1, 0}, {2, 0}, {3, 1}, {3, 2} };
        int[] order = ts.topologicalSort(numCourses, prerequisites);

        if (order.length == 0) {
            System.out.println("Cycle detected, no topological ordering exists.");
        } else {
            System.out.println("Topological order: " + Arrays.toString(order));
        }
    }
}

