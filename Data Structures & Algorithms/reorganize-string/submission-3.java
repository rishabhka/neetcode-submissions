class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a,b) -> (b[0]-a[0])
        ); // freq , inx
        int [] nums = new int [26] ;
        for(char c : s.toCharArray())
        {
            nums[c-'a'] ++ ;
        }
        for(int i=0;i<26;i++)
        {
        if(nums[i]==0)
        continue ;
        pq.offer(new int []{nums[i],i,0}) ;
    }

        if((float)pq.peek()[0]>=(float)s.length()/2+1)
        return "" ;
        String result = "";
        int time = 0;
        while(!pq.isEmpty())
        {
            
            int [] node = pq.poll();
            if(node[2]>time)
            {
                int [] temp = pq.poll();
                pq.offer(node);
                node=temp;
            }
            result = result + (char)(node[1] + 'a') ;
            if(node[0]>1)
            pq.offer(new int []{node[0]-1,node[1],time+2});
            time ++;
        }

        return result ;
    }
}