class Solution {
    class Node 
    {
        int a ;
        int p ; 
        int i ;
        Node(int a , int p , int i){
            this.a=a; this.p=p; this.i = i ;
        }
    }
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->
        {
            if(a.p==b.p) return Integer.compare(a.i,b.i) ;
            else return Integer.compare(a.p,b.p) ;
        });
        int [] res = new int [tasks.length] ;
        Queue<Node> q = new LinkedList<>();
        Node [] node = new Node [tasks.length] ; 
        for(int i=0;i<tasks.length;i++)
        {
            node[i] = new Node(tasks[i][0],tasks[i][1],i) ;
        }
        Arrays.sort(node,(a,b)->
        {
            return Integer.compare(a.a,b.a) ;
        }) ;
        for(int i=0;i<tasks.length;i++)
        {
            q.offer(node[i]) ;
        } 
        int time = 0; int i=0 ;
        while(!pq.isEmpty() || !q.isEmpty())
        {
            while(!q.isEmpty()&& q.peek().a <=time)
            {
                pq.offer(q.poll()) ;
            }
            if(!pq.isEmpty())
            {
                Node temp = pq.poll();
                time = time + temp.p ;
                res[i] = temp.i ;
                i++;
            }
            else
            time ++;

        }
        return res ;
    }
}