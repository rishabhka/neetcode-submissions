class Solution {
    public int leastInterval(char[] tasks, int n) {
        // (node,freq,time)
        PriorityQueue<int [] > pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(b[1],a[1]) ;
        });
        Queue<int[] > q = new LinkedList<>();
        int [] freq = new int[26] ;
        for(int i=0;i<tasks.length;i++)
        {
            freq[tasks[i]-'A'] = freq[tasks[i]-'A'] + 1;
        }
        for(int i=0;i<26;i++)
        {
        if(freq[i]!=0) pq.offer(new int []{i,freq[i],0});
        } 
        int time = 0;
        while(!pq.isEmpty()||!q.isEmpty())
        {
            while(!q.isEmpty()&&q.peek()[2]<time)
            {
                int [] node = q.poll();
                pq.offer(node) ;
            }
            if(!pq.isEmpty())
            {
            int [] nd = pq.poll();
            if(nd[1]>1) q.offer(new int []{nd[0],nd[1]-1,time+n}) ;
            }
            time ++;
        }
        return time ;
    }
}
