class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int [] > pq = new PriorityQueue<>((x,y)->(y[1]-x[1]));

        if(a!=0) pq.add(new int []{0,a}) ;
        if(b!=0) pq.add(new int []{1,b}) ;
        if(c!=0) pq.add(new int []{2,c}) ;

        int [] cooldown = new int [3] ;
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty())
        {
            int [] node = pq.poll();
            if(cooldown[node[0]]==2)
            {
                if(pq.isEmpty())
                return result.toString();
                int [] temp = pq.poll();
                pq.offer(node);
                // cooldown[node[0]] = 0;
                node = temp ;
                
            }
            
           
            result.append((char) (node[0] + 'a'));
            if(node[1]>1)
            pq.add(new int []{node[0],node[1]-1});
            // Put all zero except the current 
            for(int i=0;i<3;i++)
            {
                if(i==node[0])
                continue ;
               cooldown[i] = 0; 
            }
             cooldown[node[0]] ++ ;
        }
        return result.toString();
    }
}