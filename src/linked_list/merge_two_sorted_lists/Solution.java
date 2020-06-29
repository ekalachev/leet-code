package linked_list.merge_two_sorted_lists;

import linked_list.ListNode;

public class Solution {
    // time complexity: O(n + m), space complexity: O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode current1 = l1;
        for (int i = 2; i <= 5; i++) {
            current1.next = new ListNode(i);
            current1 = current1.next;
        }

        ListNode l2 = new ListNode(2);
        ListNode current2 = l2;
        for (int i = 2; i <= 7; i++) {
            current2.next = new ListNode(i);
            current2 = current2.next;
        }

        Solution solution = new Solution();
        ListNode mergedHead = solution.mergeTwoLists(l1, l2);

        ListNode current = mergedHead;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
