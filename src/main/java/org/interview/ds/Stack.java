package org.interview.ds;

public class Stack {

    private Node top;
    private int height;

    class Node{
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
    Node node = new Node(value);
    top = node;
    height = 1;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
        }else{
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        if(height == 0) return null;
        Node temp = top;
        top= top.next;
        temp.next = null;
        height--;
        return temp;
    }

    public void printStack(){
        System.out.println("--------------------------------");
        Node temp = top;
        while(temp !=null){
            System.out.println("value : "+temp.value);
            temp = temp.next;
        }
    }

    public void getTop(){
        System.out.println("top : "+top.value);
    }

    public void getHeight(){
        System.out.println("Height : "+height);
    }
}
