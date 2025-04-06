package org.interview.questions.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
public class CloneGraph {

    // HashMap to store cloned nodes: original node -> cloned node
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // If the node has already been cloned, return the clone.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new node with the same value as the original.
        Node clone = new Node(node.val);
        // Save the clone in the map before processing neighbors to avoid cycles.
        visited.put(node, clone);

        // Iterate through the neighbors and recursively clone them.
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        // Create a simple test graph.
        // For example, a graph with two nodes where node 1 is connected to node 2,
        // and node 2 is connected back to node 1.
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        CloneGraph solution = new CloneGraph();
        Node clonedGraph = solution.cloneGraph(node1);

        // Print the cloned graph's first node and its neighbor to verify the clone.
        System.out.println("Cloned node value: " + clonedGraph.val);
        System.out.println("Neighbor value: " + clonedGraph.neighbors.get(0).val);
    }
}
