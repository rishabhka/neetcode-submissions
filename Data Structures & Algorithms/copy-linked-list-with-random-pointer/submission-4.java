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
        if(head == null)
        return null;
        HashMap<Node,Node> nodeToNode = new HashMap<>();
        HashMap<Node,Node> nodeToRandom = new HashMap<>();
        Node temp = head ;
        Node start = new Node(temp.val) ;
        Node copyTemp = start ;
        Node prev = temp;
        temp = temp.next;
        // nodeToNode.add(prev,copyTemp);
        while(temp!=null)
        {
            Node newNode = new Node(temp.val);
            copyTemp.next = newNode;
            nodeToNode.put(prev,copyTemp) ;
            nodeToRandom.put(prev,prev.random);
            prev = temp;
            temp = temp.next ;  
            copyTemp=copyTemp.next ;         
        }
        nodeToNode.put(prev, copyTemp);
nodeToRandom.put(prev, prev.random);
        temp = head ;
        copyTemp = start ;
        while(temp!=null)
        {
            Node currRandomNode = nodeToRandom.get(temp);
            Node newRandonNode = nodeToNode.get(currRandomNode);
            copyTemp.random = newRandonNode ;
            temp = temp.next ;  
            copyTemp=copyTemp.next ;
        }
        return start ;
    }
}
