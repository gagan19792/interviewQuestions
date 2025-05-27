package org.interview.ds;

public class QueueMain {

    public static void main(String[] args) {
        Queue myQueue  = new Queue(1);
        myQueue.printQueue();
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.printQueue();
        myQueue.deQueue();
        myQueue.printQueue();
    }
}
