package org.interview.ds;

public class Queue {

    class Node{
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
    Node node = new Node(value);
    first = node;
    last = node;
    length = 1;
    }

    public void enqueue(int value){
        Node node = new Node(value);
        if(length == 0){
            first = node;
            last = node;
        }else {
            last.next = node;
            last = node;
        }
        length++;
    }

    public Node deQueue(){
        if(length == 0) return null;
        Node temp = first;
        if(length == 1)
        {
            first = null;
            last = null;
        }else{
            first = first.next;
            temp.next = null;
        }
        length--;
        return  temp;
    }

    public void printQueue(){
        System.out.println("-----------------------");
        Node temp = first;
        while(temp !=null){
            System.out.println("value : "+temp.value);
            temp = temp.next;
        }
    }
}
