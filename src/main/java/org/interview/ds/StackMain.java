package org.interview.ds;

public class StackMain {

    public static void main(String[] args) {
        Stack myStack = new Stack(1);
        myStack.push(2);
        myStack.push(3);
        myStack.printStack();
        myStack.pop();
        myStack.printStack();
    }
}
