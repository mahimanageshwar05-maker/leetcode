/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        // find middle
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse half right part
        ListNode prev = null;
        ListNode after = null;
        ListNode curr = slow;
        while(curr != null)
        {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        ListNode right = prev;
        ListNode left = head;
        // check left half and right half
        while(right != null)
        {
            if(left.val != right.val)
            {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
}