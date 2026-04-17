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
        HashMap<Node,Node> map1 = new HashMap<>(); // copied to orignal
        HashMap<Node,Node> map2 = new HashMap<>(); // orignal to orignal random
        HashMap<Node,Node> map3 = new HashMap<>(); // orignal to copied
        if(head==null)
        return null;
        // Node head2 = new Node(head.val);
        Node temp = head ;
        Node prev = null ;
        Node head2 = null ;
        while(temp!=null)
        {
            map2.put(temp,temp.random);
            Node newNode = new Node (temp.val);
            if(prev == null)
            {
            head2 = newNode ;
            prev = newNode ;
            map1.put(temp,prev);
            map3.put(prev,temp);
            }
            else
            {
            prev.next = newNode;
            map1.put(temp,newNode);
            map3.put(newNode,temp);
            prev = prev.next ;
            }
            temp = temp.next ;
        }
        prev = head2;
        while(prev!=null)
        {
          Node copiedNode = prev ;
          Node originalNode = map3.get(copiedNode);
          Node oldRandom = map2.get(originalNode);
          Node newRandom =null;
          if(oldRandom!=null)
          newRandom = map1.get(oldRandom);
          prev.random = newRandom;
          prev = prev.next ;  
        }
        prev = head2;
        return head2;
        
    }
}
