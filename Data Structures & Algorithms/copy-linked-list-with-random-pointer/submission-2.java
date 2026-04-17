/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map1 = new HashMap<>(); // orignal to copied
        Node head2 = null , temp = head ;
        Node prev = null;
        while(temp!=null)
        {
            Node newNode = new Node (temp.val);
            if(prev == null)
            {
            head2 = newNode ;
            prev = newNode ;
            map1.put(temp,prev);
            }
            else
            {
            prev.next = newNode;
            map1.put(temp,newNode);
            prev = prev.next ;
            }
            temp = temp.next ;
        }
        prev = head2;
        Node old = head ;
        while(prev!=null)
        {
          Node copiedNode = map1.get(old);
          if(old.random==null)
          prev.random = null;
          else
          {
            Node newRandom = map1.get(old.random);
            prev.random = newRandom;
          }
          prev = prev.next ;  
          old = old.next ;
        }
        
        return head2;
    }
}
