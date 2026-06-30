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
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next ==null) return head ;
        ListNode p = head ;
        ListNode q = head.next ;
        while(q!=null)
        {
            ListNode r = q.next ;
            q.next = p;
            p=q;
            q=r;
        }
        head.next = null;
        return p;
    }
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return ;
        ListNode slow = head ;
        ListNode fast = head ;
        while(fast.next!=null&&fast.next.next!=null)
        {
            slow = slow.next ;
            fast = fast.next.next ;
        }
        ListNode second = slow;
        slow = slow.next ;
        second.next = null;
        ListNode q = reverseList(slow);
        ListNode p = head;

        while(p!=null&&q!=null)
        {
            ListNode t1 =p.next;
            ListNode t2 =q.next ;
            p.next = q;
            q.next = t1 ;
            p = t1;
            q= t2;
        }
        return ;
    }
}
