package org.interview.questions.graph;

import java.util.HashMap;
import java.util.Map;

public class CloneGraphDFS {
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node){
        if(node == null) return null;
        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node clone = new Node(node.val);

        visited.put(node, clone);

        for(Node neighbour: node.neighbors){
            clone.neighbors.add(cloneGraph(neighbour));
        }

        return clone;

    }
}
