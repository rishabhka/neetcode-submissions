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
    public ListNode merge(ListNode p,ListNode q)
    {
        if(p==null) return q ;
        if(q==null) return p ;
        ListNode temp  = new ListNode() ; ListNode start = temp ;
        while(p!=null&&q!=null)
        {
            if(p.val<=q.val)
            {
                temp.next = p;
                p = p.next ;
            }
            else 
            {
                temp.next = q;
                q= q.next ;
            }
            temp = temp.next ;
        }
        if(q!=null)
        temp.next = q;
        if(p!=null)
        temp.next = p;
        return start.next ;

    }
    public ListNode binaryMerge(ListNode[] lists,int i,int j)
    {
        if(i>=j) return lists[i] ;
        else
        {
            int mid = (i+j) >> 1;
            ListNode x = binaryMerge(lists,i,mid) ;
            ListNode y = binaryMerge(lists,mid+1,j) ;
            return merge( x, y) ;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        else if (lists.length==1) return lists[0] ;
        return binaryMerge(lists,0,lists.length-1) ;
    }
}
