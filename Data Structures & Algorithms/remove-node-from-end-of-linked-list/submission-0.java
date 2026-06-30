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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count =0;
        ListNode p = head ;
        while(p!=null)
        {
            count ++;
            p= p.next ;
        }
        int fromstart = count -n ;
        if(fromstart==0) return head.next ;
        p = head ;
        ListNode q = null ;
        while(fromstart!=0)
        {
            q=p;
            p=p.next;
            fromstart--;
        }
        q.next =p.next;
        return head;
    }
}
