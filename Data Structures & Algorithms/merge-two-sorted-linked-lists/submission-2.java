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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = list1 ;
        ListNode q = list2 ;
        ListNode head = new ListNode(0) ;
        ListNode temp = head ;
        while(p!=null&&q!=null)
        {
            if(p.val<=q.val)
            {
                temp.next = p;
                p = p.next; 
            }
            else
            {
                temp.next = q;
                q=q.next ;
            }
            temp = temp.next ;
        }
        if(q!=null)
        temp.next = q;
        else if(p!=null)
        temp.next = p;
        return head.next ;
    }
}