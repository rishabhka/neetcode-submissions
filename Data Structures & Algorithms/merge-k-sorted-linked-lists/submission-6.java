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
    public ListNode mergeList(ListNode p, ListNode q)
    {
        ListNode temp = new ListNode() ; ListNode head = temp ;
        while(p!=null && q!=null)
        {
            if(p.val<=q.val)
            {
                temp.next = p ;
                p = p.next ;
            }
            else
            {
                temp.next = q ;
                q= q.next ;
            }
            temp = temp.next ;
        }
        if(p!=null)
        temp.next = p ;
        if(q!=null)
        temp.next = q ;
        return head.next ;
    }
    public ListNode merge(int i , int j ,ListNode[] lists )
    {
        if(i==j) return lists[i];
        int mid = (i+j) >> 1 ;
        ListNode left  = merge(i,mid,lists) ;
        ListNode right = merge(mid+1,j,lists) ;
        return mergeList(left,right);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int i =0 ; int j = lists.length ;
        return merge(i,j-1,lists);
    }
}
