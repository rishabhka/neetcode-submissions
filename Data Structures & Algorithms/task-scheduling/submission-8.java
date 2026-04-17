class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));  // (char index , # of times )

        int [] counter = new int [26] ;

        for(char c : tasks)
        counter[c-'A']++ ;

        for(int i=0;i<26;i++)
        {
            if(counter[i]==0)
            continue ;
            pq.offer(new int [] {i ,counter[i] });
        }
        Queue <int [] > q = new LinkedList<>() ;  // (char index , available time )
        int current_time = 0;
        String result = "";

        while(!pq.isEmpty() || !q.isEmpty())
        {
            if(!pq.isEmpty())
            {
                int [] node = pq.poll();
                result = result + (char)(node[0] + 'A') ;
                if(node[1]-1>0)
                q.add(new int [] {node[0],current_time + n,node[1]-1});
                
            } else 
            result = result + " ";

            if(!q.isEmpty()&& q.peek()[1]<=current_time)
            {
            int [] node = q.poll();
            pq.add(new int [] {node[0],node[2] });
            }
            current_time ++ ;

        }
        System.out.println(result);
        return current_time;
    }
}
