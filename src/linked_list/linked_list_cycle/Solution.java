package linked_list.linked_list_cycle;

import linked_list.ListNode;

public class Solution {
    // time complexity: O(n), space complexity: O(1)
    public boolean hasCycle(final ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode rabbit = head, turtle = head;

        while (rabbit != null && turtle != null && rabbit.next != null) {
            rabbit = rabbit.next.next;
            turtle = turtle.next;

            if (rabbit == turtle)
                return true;
        }

        return false;
    }

    public static void main(final String[] args) {
        final ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4, head.next);

        final Solution solution = new Solution();
        final boolean hashCycle = solution.hasCycle(head);

        System.out.println("Has cycle: " + hashCycle);
    }
}