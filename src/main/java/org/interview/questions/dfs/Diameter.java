package org.interview.questions.dfs;

public class Diameter {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    private int diameter = 0;  // holds the best diameter found

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    // Returns the height of the subtree rooted at `node`
    private int height(TreeNode node) {
        if (node == null) return 0;

        // Recursively get heights of left and right subtrees
        int leftH  = height(node.left);
        int rightH = height(node.right);

        // The path through this node would be leftH + rightH edges
        diameter = Math.max(diameter, leftH + rightH);

        // Height of this node is 1 + the taller subtree
        return 1 + Math.max(leftH, rightH);
    }

    // Example test
    public static void main(String[] args) {
        /*
             Construct this tree:
                 1
                / \
               2   3
              / \
             4   5

             Its diameter path is 4→2→1→3 or 5→2→1→3, length = 3 edges.
        */
        TreeNode root = new TreeNode(1);
        root.left  = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left  = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Diameter solver = new Diameter();
        int result = solver.diameterOfBinaryTree(root);
        System.out.println("Diameter (in edges): " + result);
        // Expected output: 3
    }
}
