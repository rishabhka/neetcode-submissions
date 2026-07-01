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
    public void reverse(ListNode head)
    {
        if(head ==null||head.next ==null) return ;
        ListNode p =head ;
        ListNode q =head.next ;
        while(q!=null)
        {
            ListNode temp = q.next ;
            q.next = p;
            p=q;
            q=temp;
        }
        head.next = null;
        // return p;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head ;
        ListNode prevNode = head ;
        
        ListNode nextNode = head ;
        while(true)
        {
            ListNode kthNode = temp ;
            if (temp == null) break;
            for(int i=0;i<k-1;i++)
            {
                kthNode = kthNode.next;
                if(kthNode==null)
                { 
                prevNode.next = temp;   
                return head ;
                }
                
            }
            nextNode=kthNode.next ;
            kthNode.next =null;
            reverse(temp);
            if(temp==head) // For first loop
            head = kthNode;
            else prevNode.next = kthNode;
            prevNode=temp;
            temp = nextNode;
        }
        return head;
    }
}
