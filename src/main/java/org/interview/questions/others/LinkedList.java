package org.interview.questions.others;

public class LinkedList<T extends Comparable<T>> {

    private Node<T> head =null;
    private int length=0;
    public LinkedList(){
    }

    public void addNode(T data){
        if(head == null){
            head = new Node<T>(data);
            length++;
        }else{
            Node<T> currentNode = head;
            while(currentNode.getNext() !=null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node<T>(data));
        }
    }
}
