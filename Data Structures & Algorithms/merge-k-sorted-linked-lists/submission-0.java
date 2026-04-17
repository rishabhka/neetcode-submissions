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

    public ListNode merge (ListNode list1,ListNode list2)
    {
     if(list1==null)
     return list2;
     if(list2==null)
     return list1;
     ListNode head = null;
     ListNode temp = null;
     while(list1!=null&&list2!=null)
     {
        if(list1.val<list2.val)
        {
            if(temp == null)
            {
            temp = list1;
            head = list1;
            }
            else 
            {
            temp.next = list1;
            temp = temp.next ;
            }
            list1=list1.next;
        }
        else
        {
            if(temp == null)
            {
            temp = list2;
            head = list2;
            }
            else 
            {
            temp.next = list2;
            temp = temp.next ;
            }
            list2=list2.next;
        }
        
     }
     if(list1!=null)
     {
        temp.next = list1;
     }
     if(list2!=null)
     {
        temp.next = list2;
     }
     return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
     int n = lists.length;
     if(n==0)
     return null;
     if(n==1)
     return lists[0];
     ListNode sumList = lists[0];
     for(int i=1;i<n;i++)
     {
        sumList = merge(sumList,lists[i]);
     }
     return sumList ;
    }
}
