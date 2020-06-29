package linked_list.remove_nth_node_from_end_of_list;

import linked_list.ListNode;

public class Solution {
    // time complexity: O(n), space complexity: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i < n + 1; i++)
            first = first.next;

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        Solution solution = new Solution();
        ListNode result = solution.removeNthFromEnd(head, 2);

        ListNode node = result;
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}