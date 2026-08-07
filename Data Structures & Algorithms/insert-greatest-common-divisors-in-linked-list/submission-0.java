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
 // 2,4 -> 2,0
class Solution {
    public int gcd(int a,int b)
    {
        if(b==0) return a ;
        return gcd(b,a%b) ;

    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null||head.next==null) return head ;
        ListNode p = head ; ListNode q = head.next ;
        while(q!=null)
        {
            ListNode div = new ListNode(gcd(p.val,q.val));
            p.next = div ;
            div.next = q ;
            p = q ;
            q = q.next ;
        }
        return head ;
    }
}