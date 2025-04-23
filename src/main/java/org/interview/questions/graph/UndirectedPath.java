package org.interview.questions.graph;

import java.util.*;

public class UndirectedPath {

    public static void main(String[] args) {
        int[][] edges = new int [][] {{0,1},{1,2},{2,0}, {5,4}};
        System.out.println(hasPath(buildAdjecencyList(edges), 1, 2, new HashSet<Integer>()));
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

    public static boolean hasPath(Map<Integer, List<Integer>> graph, int src, int dst, Set<Integer> visited){
        if(src == dst) return true;
        if(visited.contains(src)) return false;

        visited.add(src);
        if(graph.get(src) !=null){
            for(int n : graph.get(src)){
                if(hasPath(graph, n, dst, visited)) return true;
            }
        }
        return false;
    }
}
