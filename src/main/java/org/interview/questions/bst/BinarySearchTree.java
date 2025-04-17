package org.interview.questions.bst;

public class BinarySearchTree {

    Node root;

    class Node{
        int val;
        Node left;
        Node right;

        public Node(int value){
            this.val = value;
        }
    }
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true){
            if(newNode.val == temp.val) return false;
            if(newNode.val < temp.val){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }else {
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        if(root == null) return false;
        Node temp = root;
        while(temp !=null){
             if (value < temp.val) {
                 temp = temp.left;
            }else if(value > temp.val){
                 temp = temp.right;
             }else{
                 return true;
             }



        }
        return false;
    }
}
