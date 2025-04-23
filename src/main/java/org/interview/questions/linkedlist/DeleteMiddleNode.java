package org.interview.questions.linkedlist;

public class DeleteMiddleNode {


    // Simple tests
    public static void main(String[] args) {
        int[][] tests = {
                {1,3,4,7,1,2,6},  // middle is 7 (index 3)
                {1,2,3,4},        // middle is 3 (index 2)
                {2,1},            // middle is 1 (index 1)
                {1},              // single node → null
                {}                // empty → null
        };
        for (int[] t : tests) {
            ListNode head = build(t);
            ListNode res = deleteMiddle(head);
            System.out.printf("%s → %s%n",
                    toString(build(t)),
                    res == null ? "null" : toString(res));
        }
    }

    // Helper to build a list from array
    private static ListNode build(int[] vals) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    // Helper to print list
    private static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(head.next != null ? "→" : "");
            head = head.next;
        }
        return sb.toString();
    }

    // Definition for singly‑linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    /**
     * Deletes the middle node of the list and returns the head of the resulting list.
     * If the list has only one node, returns null.
     */
    public static ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head; ListNode fast = head; ListNode prev = null;

        while(fast!=null && fast.next !=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
