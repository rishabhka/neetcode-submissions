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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;
        Boolean start = true ;
        if(head==null)
        return false;
        while(slow!=fast||start)
        {
            start = false;
            if(slow.next!=null)
            slow = slow.next;
            else return false;
            if(fast.next!=null)
            fast= fast.next;
            else return false;
            if(fast.next!=null)
            fast= fast.next;
            else return false;
        }
        return true;
    }
}
