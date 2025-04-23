package org.interview.questions.graph;

import java.util.*;

public class HasPath {

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('f',List.of('g','i'));
        graph.put('g',List.of('h'));
        graph.put('i',List.of('g','k'));
        graph.put('j',List.of('i'));
        System.out.println(hasPathDFS(graph, 'f', 'k'));
        System.out.println(hasPathBFS(graph, 'f', 'k'));    }

    public static boolean hasPathDFS(Map<Character, List<Character>> graph, char src, char dst){
        if(src == dst){
            return true;
        }

        if(graph.get(src) != null){
            for(char c :graph.get(src)){
                if(hasPathDFS(graph, c, dst)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathBFS(Map<Character, List<Character>> graph, char src, char dst){
        Queue<Character> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            char ch = queue.poll();
            if(ch == dst) return true;

            if(graph.get(ch) != null){
                for(char c: graph.get(ch)){
                    queue.add(c);
                }
            }
        }
        return false;
    }
}
