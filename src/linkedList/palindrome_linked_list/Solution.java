package linkedList.palindrome_linked_list;

import linkedList.ListNode;

public class Solution {
    // time complexity: O(n), space complexity: O(1)
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        // find the first part of the linked list
        ListNode endOfFirstPart = findEndOfFirstPart(head);

        // revert the second part of the linked list
        ListNode revertedSecondPart = reverse(endOfFirstPart.next);

        // check if the linked list is palindrome
        ListNode p1 = head, p2 = revertedSecondPart;
        boolean isPalindrome = true;
        while (isPalindrome && p2 != null) {
            isPalindrome = p1.val == p2.val;

            p1 = p1.next;
            p2 = p2.next;
        }

        // revert the second part back
        endOfFirstPart.next = reverse(revertedSecondPart);

        return isPalindrome;
    }

    private ListNode findEndOfFirstPart(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))));

        Solution solution = new Solution();
        boolean isPalindrome = solution.isPalindrome(head);

        System.out.println("Is palindrome: " + isPalindrome);
    }
}