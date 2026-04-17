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
        if(list1==null)
        return list2;
        if(list2==null)
        return list1;

        ListNode head = null;
        ListNode start = null;

        ListNode p = list1;
        ListNode q = list2;

        while(p!=null&&q!=null)
        {
          if(p.val>=q.val)
          {
            if(head == null)
            {
            head = q ;
            start = head ;
            }
            else
            {
            head.next = q;
            head = head.next ;
            }
            q= q.next;
          }
          else
          {
            if(head == null)
            {
            head = p;
            start = head ;
            }
            else
            {
            head.next = p;
            head = head.next ;
            }
            p= p.next;
          }
        }
        while(p!=null)
        {
            head.next = p;
            head = head.next;
            p= p.next;
        }
        while(q!=null)
        {
            head.next = q;
            head = head.next;
            q= q.next;
        }
    return start ;
    }
}