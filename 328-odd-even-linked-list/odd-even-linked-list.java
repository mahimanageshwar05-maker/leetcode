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
    public ListNode oddEvenList(ListNode head) {
        ListNode Odd = new ListNode(0);
        ListNode Even = new ListNode(0);
        ListNode tempO = Odd;
        ListNode tempE = Even;
        ListNode temp = head;

        while(temp != null)
        {
            // for odd
            tempO.next = temp;
            temp = temp.next;
            tempO = tempO.next;

            // for even
            tempE.next = temp;
            if(temp == null)
                break;
            temp = temp.next;
            tempE = tempE.next;
        }
        Odd = Odd.next;
        Even = Even.next;
        tempO.next = Even;
        return Odd;
    }
}