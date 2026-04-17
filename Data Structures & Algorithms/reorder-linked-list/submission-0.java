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

    public ListNode reverse(ListNode head )
    {
        if(head == null || head.next == null)
        return head;
        else
        {
           ListNode p = head;
           ListNode q = head.next ;
           p.next = null;
           while(q!=null)
           {
            ListNode temp = q.next ;
            q.next = p;
            p= q;
            q= temp;
           }
           return p;
        }
    }
    public void reorderList(ListNode head) {
        
    int count = 0;
    ListNode start = head ;
    if(head == null || head.next == null || head.next.next == null)
    return ;
    while(start!=null)
    {
        start = start.next;
        count++;
    }
    int limit = count / 2 ;
    start = head ;
    ListNode prev = start ;
    while(limit!=0)
    {
     prev = start;
     start = start.next ;
     limit -- ;
    }
    prev.next = null;
    ListNode q = reverse(start);
    ListNode p = head ;
    boolean flag = true;
    ListNode answer = null;
    while(p!=null&&q!=null)
    {
        ListNode temp = p.next ;
        ListNode temp2 = q.next ;
        p.next = q;
        if(temp!=null)
        q.next = temp ;
        p = temp;
        q = temp2;
    }
    return ;
    

    }
}
