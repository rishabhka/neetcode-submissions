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
        int cnt =0 ; ListNode p = head ;
        while(p!=null)
        {
            p=p.next; cnt ++;
        }
         cnt = cnt-n; p = head ; ListNode prev = null ;
        if(cnt==0) return head.next;
        while(cnt!=0)
        {
            prev= p ;
            p=p.next;
            cnt--;
        }
        prev.next =p.next ;
        return head ;
    }
}
