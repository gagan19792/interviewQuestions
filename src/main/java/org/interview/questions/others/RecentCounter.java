package org.interview.questions.others;

import java.util.ArrayDeque;
import java.util.Deque;

public class RecentCounter {
    private Deque<Integer> dequeue;

    public RecentCounter(){
        this.dequeue = new ArrayDeque<>();
    }

    public int ping(int t){
        dequeue.addLast(t);

        while(dequeue.peekFirst() < t-3000){
            dequeue.removeFirst();
        }
        return  dequeue.size();
    }

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));     // 1   (only [1])
        System.out.println(rc.ping(100));   // 2   ([1,100])
        System.out.println(rc.ping(3001));  // 3   ([1,100,3001])
        System.out.println(rc.ping(3002));  // 3   ([100,3001,3002]) drops 1
    }
}
