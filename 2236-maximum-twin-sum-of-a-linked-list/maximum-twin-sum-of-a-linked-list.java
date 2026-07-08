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
    public int pairSum(ListNode head) 
    {
        if(head == null || head.next == null)
        {
            return head.val + head.next.val;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        ListNode after = null;

        while(curr != null)
        {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        
        ListNode right = prev;
        ListNode left = head;
        int max = -1;

        while(right != null)
        {
            int sum = left.val + right.val;
            if(sum >= max)
            {
                max = sum;
            }
            left = left.next;
            right = right.next;
        }
        return max;
    }
}