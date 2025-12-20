package org.interview.questions.sorting;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortStack {

//    Time	O(n²) (worst case, insertion-style)
//    Space	O(n) (auxiliary stack)
    public static void sortStack(Deque<Integer> stack){
        Deque<Integer> tempStack = new ArrayDeque<>();
        while(!stack.isEmpty()){
            int current = stack.pop();

            while(!tempStack.isEmpty() && tempStack.peek() > current){
                stack.push(tempStack.pop());
            }
            tempStack.push(current);
        }
        //Copy back to original stack
        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        System.out.println(stack.toString());
        sortStack(stack);
        System.out.println(stack.toString());
    }
}
