class Solution {
    public class Node 
    {
        int val ;
        int dist ;
        Node(int val,int dist)
        {
            this.val = val ;
            this.dist = dist ;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->b.dist-a.dist);
        List<Integer> result = new ArrayList<>();
        for(int num : arr)
        {
            if(pq.size()<k)
            pq.add(new Node(num,Math.abs(num-x)));
            else if(pq.peek().dist>Math.abs(num-x))
            {
                
                pq.poll();
                pq.add(new Node(num,Math.abs(num-x)));
            }
        }
        while(!pq.isEmpty())
        {
            result.add(pq.poll().val);
        }
        Collections.sort(result);
        return result ;
    }
}