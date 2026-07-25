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
    public ListNode reverse(ListNode p)
    {
        ListNode q = p.next ; ListNode head = p ;
        while(q!=null)
        {
            ListNode temp = q.next;
            q.next = p;
            p=q;
            q= temp;
        }
        head.next = null;
        return p;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head ; ListNode p = head ; ListNode q = head; int l = left ;
        ListNode prev = new ListNode() ; prev.next = head ; ListNode dummy = prev ;
        ListNode next = head; int max = Math.max(left,right);
        while(left!=1||right!=1)
        {
            if(left!=1)
            {
            prev = p;
            p = p.next;
            left--;
            }
            if(right!=1)
            {
            q = q.next;
            next=q.next ;
            right --;
            }
        }
        q.next = null;
        reverse(p) ;
        prev.next = q;
        p.next = next;
        return dummy.next ;
    }
}