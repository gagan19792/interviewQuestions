package org.interview.questions.linkedlist;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class TwoSum {
    public ListNode twoSum(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        while(l1 != null || l2 !=null){
            int x = (l1 !=null) ?l1.val:0;
            int y = (l2 !=null) ?l2.val:0;

            int sum = carry+x+y;
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;

            if(l1 !=null){
                l1=l1.next;
            }
            if(l2 !=null){
                l2 = l2.next;
            }
        }

        if(carry>0){
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    // Helper method to print the linked list.
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }

    // Main method for testing the solution.
    public static void main(String[] args) {
        // Create first number: 342 represented as (2 -> 4 -> 3)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second number: 465 represented as (5 -> 6 -> 4)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Expected output: 807 represented as (7 -> 0 -> 8)
        TwoSum solution = new TwoSum();
        ListNode result = solution.twoSum(l1, l2);

        // Print the result
        System.out.print("Result: ");
        printList(result);
    }
}
