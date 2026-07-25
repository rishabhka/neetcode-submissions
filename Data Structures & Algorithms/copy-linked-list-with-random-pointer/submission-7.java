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
        Node head2 = new Node(0);
        Node p = head ; Node q = head2 ;
        HashMap<Node,Node> map = new HashMap<>();
        HashMap<Node,Node> nToN = new HashMap<>();
        while(p!=null)
        {
            Node temp = new Node(p.val);
            nToN.put(p,temp);
            map.put(p,p.random);
            q.next = temp ;
            p=p.next;
            q= q.next ;
        }
        p = head ; q = head2.next ;
        while(p!=null)
        {
            Node node = nToN.get(map.get(p)) ;
            q.random = node ;
            p = p.next ;
            q=q.next ;
        }
        return head2.next ;
    }
}
