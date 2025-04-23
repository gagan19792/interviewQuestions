package org.interview.questions.graph;

import java.util.*;

public class ConnectedComponentCount {

    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{1,2},{3,4}};
        System.out.println(connectedComponentCoun(buildAdjecencyList(edges1)));
        // → 2  (components: {0,1,2} and {3,4})

        int[][] edges2 = {{0,1},{1,2},{2,3},{3,4}};
        System.out.println(connectedComponentCoun(buildAdjecencyList(edges2)));
        // → 1  (all connected)

        int[][] edges3 = {};
        System.out.println(connectedComponentCoun(buildAdjecencyList(edges3)));
        // → 4  (no edges, each node is its own component)

        int[][] edges4 = {{0,1},{2,3}};
        System.out.println(connectedComponentCoun(buildAdjecencyList(edges4)));
        // → 4  (components: {0,1}, {2,3}, {4}, {5})

    }

    public static Map<Integer, List<Integer>>  buildAdjecencyList(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int edge[] : edges){{
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<>()).add(a);
        }

        }
        return graph;
    }

    public static int connectedComponentCoun(Map<Integer, List<Integer>> graph){
        visited.clear();
        int count = 0;
        for(Integer node: graph.keySet()){
            if(explore(graph, node, visited)){
                count++;
            }
        }

        return count;
    }

    private static boolean explore(Map<Integer, List<Integer>> graph, Integer node, Set<Integer> visited) {
        if(visited.contains(node)) return false;
        visited.add(node);
        for(int current: graph.get(node)){
            explore(graph, current, visited);
        }
        return true;
    }
}
