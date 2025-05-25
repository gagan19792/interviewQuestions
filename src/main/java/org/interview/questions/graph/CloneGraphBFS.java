package org.interview.questions.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraphBFS {

    public Node cloneGraphBFS(Node node){
        if(node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node clone = new Node(node.val);
        visited.put(node, clone);
        queue.add(node);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            for(Node neighbour: current.neighbors){
                if(!visited.containsKey(neighbour)){
                    visited.put(neighbour, new Node(neighbour.val));
                    queue.add(neighbour);
                }
                visited.get(current).neighbors.add(visited.get(neighbour));
            }
        }
        return clone;
    }
}
