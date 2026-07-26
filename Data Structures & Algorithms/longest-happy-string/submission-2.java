class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // (char , count , time)
        PriorityQueue<int []> pq = new PriorityQueue<>((x,y)->
        {
            return Integer.compare(y[1],x[1]) ;
        });
        if(a!=0) pq.offer(new int []{0,a}) ;
        if(b!=0) pq.offer(new int []{1,b}) ;
        if(c!=0) pq.offer(new int []{2,c}) ;
        String res = "" ;
        while(!pq.isEmpty())
        {
            int [] first = pq.poll();
            int n = res.length ();
            if(n>=2&&res.charAt(n-1)-'a'==first[0]&&res.charAt(n-2)-'a'==first[0])
            {
                if(pq.isEmpty()) return res ;
                int [] sec = pq.poll();
                res = res + (char)(sec[0]+ 'a') ; 
                if(sec[1]-1!=0)
                pq.add(new int [] {sec[0],sec[1]-1});
                pq.add(new int [] {first[0],first[1]});
            }
            else
            {
                res = res + (char)(first[0]+ 'a') ;
                if(first[1]-1!=0)
                pq.add(new int [] {first[0],first[1]-1});
            }      
        }
        return res ;
    }
}