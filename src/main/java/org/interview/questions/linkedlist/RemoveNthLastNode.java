package org.interview.questions.linkedlist;

import java.util.LinkedList;

public class RemoveNthLastNode {

    public static ListNode removeNthLastNode(ListNode head, int n) {
        LinkedList l = new LinkedList();

        ListNode right = head;
        ListNode left = head;

        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return head;
    }

    public static int sumOfSquaredDigits(int number) {
        int totalSum = 0;                     // 1) Start with a running total of 0.
        while (number > 0) {                  // 2) Loop until we've processed every digit.
            int digit = number % 10;          //    - number % 10 gives you the last digit.
            number = number / 10;             //    - integer divide by 10 “chops off” that last digit.
            totalSum += (Math.pow(digit, 2));//    - square the digit, add it into totalSum.
        }
        return totalSum;                      // 3) When number == 0, return the accumulated sum.
    }

    public static void main(String[] args) {
        System.out.println(sumOfSquaredDigits(122));
    }
}
