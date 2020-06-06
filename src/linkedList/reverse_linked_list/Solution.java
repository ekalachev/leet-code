package linkedList.reverse_linked_list;

import linkedList.ListNode;

public class Solution {
    // time complexity: O(n), space complexity: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    // time complexity: O(n), space complexity: O(n)
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= 5; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        Solution solution = new Solution();
        head = solution.reverseListRecursive(head);

        current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

        head = solution.reverseList(head);

        current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
