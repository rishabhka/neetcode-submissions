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
    public ListNode reverse(ListNode head) 
    {
        ListNode p = head ;
        ListNode q = p.next ;
        while(q!=null)
        {
            ListNode r = q.next ;
            q.next = p;
            p=q;
            q=r ;
        }
        head.next = null;
        return p;
    }
    public void reorderList(ListNode head) {
        if(head ==null|| head.next==null) return ;
        ListNode slow = head ; ListNode fast  = head.next ;
        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next ;
            fast= fast.next.next ;
        }
        fast = slow.next ;
        slow.next = null ; 
        slow = head ;
        fast = reverse(fast) ;
        while(slow!=null&&fast!=null)
        {
            ListNode r = slow.next;
            ListNode s = fast.next ;
            slow.next = fast;
            fast.next = r;
            slow=r;
            fast=s;
        }
        return ;
    }
}
