class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time =0;
        int [] t = new int [26];
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a,b)-> Integer.compare(b[1],a[1])
        );
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<tasks.length;i++)
        {
            t[tasks[i]-'A'] ++ ;
        }
        for(int i=0;i<26;i++)
        {
            if(t[i]!=0)
            pq.add(new int []{i,t[i],0});
        }
        // String test = "";
        while(!pq.isEmpty()||!q.isEmpty())
        {
            while(!q.isEmpty()&&q.peek()[2]<time)
            {
                int [] node = q.poll();
                pq.add(node);
            }
            if(!pq.isEmpty())
            {
                int [] node = pq.poll();
                // test = test + (char)(node[0]+'A');             
                if(node[1]>1)
                q.add(new int[]{node[0],node[1]-1,time+n});
            }
            
            time ++;
        }
        return time;
    }
}
