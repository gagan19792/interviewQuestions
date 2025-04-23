package org.interview.questions.graph;

import java.util.*;

public class BFSPrint {

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a',List.of('c','b'));
        graph.put('b',List.of('d'));
        graph.put('c',List.of('e'));
        graph.put('d',List.of('f'));
        graph.put('e',List.of());
        graph.put('f',List.of());

        bfsTraversalItrative(graph, 'a');

        //dfsTraversalRecursive(graph, 'a');

    }

    private static void bfsTraversalItrative(Map<Character, List<Character>> graph, char a) {
        Queue<Character> queue = new LinkedList();
        queue.add(a);
        while(!queue.isEmpty()){
            char ch = queue.poll();
            System.out.println(ch);
            List<Character> neighbours = graph.get(ch);
            for(char c: neighbours){
                queue.add(c);
            }
        }

    }
}
