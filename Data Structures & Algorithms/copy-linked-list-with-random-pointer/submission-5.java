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
        Node p = head ;
        Node head2 = null;
        Node q =null;
        HashMap<Node,Node > map = new HashMap<>();
        while(p!=null)
        {
            if(head2==null)
            {
            head2= new Node(p.val);
            q= head2;
            }
            else
            {
            Node newNode = new Node(p.val);
            q.next = newNode;
            q=newNode;
            }
            map.put(p,q);        
            // q=q.next;
            p=p.next ;
        }
        p = head ;
        q= head2;
        while(p!=null)
        {
            Node node = p.random;
            if(node==null)
            q.random = null;
            else
            q.random = map.get(node);
            p=p.next;
            q=q.next;

        }
        // q.next = null;
        return head2;
    }
}
