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
    public ListNode merge(ListNode l1,ListNode l2)
    {
        
        if(l1==null) return l2 ;
        else if(l2==null) return l1;
        ListNode head = new ListNode(0);
        ListNode result = head ;
        while(l1!=null&&l2!=null)
        {
            if(l1.val<=l2.val)
            {
                result.next =l1;
                l1=l1.next;
            }
            else
            {
                result.next = l2;
                l2=l2.next;
            }
            result = result.next;
        }
        if(l1!=null)
        result.next = l1;
        else if(l2!=null)
        result.next =l2;
        return head.next;

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        ListNode head = lists[0];
        for(int i=1;i<lists.length;i++)
        head = merge(head,lists[i]);
        return head;
    }
}
