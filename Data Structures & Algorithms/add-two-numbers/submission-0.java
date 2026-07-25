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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(); int sum =0 ; int carry =0; ListNode p = l3 ;
        while(l1!=null&&l2!=null)
        {
            sum = l1.val+l2.val+carry ;
            carry = sum /10 ;
            sum = sum%10 ;
            ListNode temp = new ListNode(sum) ;
            p.next = temp ;
            p = p.next ;
            l1=l1.next ;
            l2=l2.next ;
        }
        while(l1!=null)
        {
           sum = l1.val + carry;
           carry = sum /10 ;
            sum = sum%10 ;
            ListNode temp = new ListNode(sum) ;
            p.next = temp ;
            p = p.next ;
            l1=l1.next ;
        }
        while(l2!=null)
        {
           sum = l2.val + carry;
           carry = sum /10 ;
            sum = sum%10 ;
            ListNode temp = new ListNode(sum) ;
            p.next = temp ;
            p = p.next ;
            l2=l2.next ;
        }
        if(l1==null&&l2==null&&carry!=0)
        p.next = new ListNode(carry);
        return l3.next ;
    }
}
