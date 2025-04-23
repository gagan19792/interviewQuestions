package org.interview.questions.dfs;

import java.util.*;

public class DFSPrint {

    public static void main(String[] args) {
        Map<Character, List<Character>> graph = new HashMap<>();
        graph.put('a',List.of('c','b'));
        graph.put('b',List.of('d'));
        graph.put('c',List.of('e'));
        graph.put('d',List.of('f'));
        graph.put('e',List.of());
        graph.put('f',List.of());

        dfsTraversalItrative(graph, 'a');

        dfsTraversalRecursive(graph, 'a');

    }
    public static  void dfsTraversalItrative(Map<Character, List<Character>> graph, char source){
        Deque<Character> stack = new ArrayDeque();
        stack.push(source);
        while(!stack.isEmpty()){
            char ch = stack.pop();
            System.out.print(ch);
            graph.get(ch).forEach(
                    stack::push
            );
        }
    }

    public static  void dfsTraversalRecursive(Map<Character, List<Character>> graph, char source){
        System.out.print(source);
        List<Character> neighbours = graph.get(source);
        for(char c: neighbours){
            dfsTraversalRecursive(graph, c);
        }
    }
}
