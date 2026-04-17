class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
       PriorityQueue<int [] > pq_cap = new PriorityQueue<>((a,b)->(a[0]-b[0]));
       PriorityQueue<int [] > pq_prf = new PriorityQueue<>((a,b)->(b[1]-a[1]));
       for(int i=0;i<profits.length;i++)
       {
        pq_cap.offer(new int [] {capital[i],profits[i]}) ;
       }
       int profit = 0;
       for(int i=0;i<k;i++){
        while(!pq_cap.isEmpty()&&pq_cap.peek()[0]<=w)
        {
          pq_prf.offer(pq_cap.poll())  ;
        }
        if(!pq_prf.isEmpty())
        {
        int [] node = pq_prf.poll();
        // System.out.println(node[1]+" "+node[0]+" "+ x);
        w= w + node[1];
        // profit = profit + node[1] ;
        }
        
       }
return w ;
    }
}