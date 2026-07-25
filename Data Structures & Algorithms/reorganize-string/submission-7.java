class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int [] freq = new int [26] ; int max_f = Integer.MIN_VALUE ;
        for(char ch : s.toCharArray())
        {
        freq[ch-'a'] = freq[ch-'a'] +1 ;
        max_f = Math.max(max_f,freq[ch-'a']) ;
        }
        if (max_f > (n + 1) / 2) return "";
        PriorityQueue<int [] > pq = new PriorityQueue<>((a,b)->
        {
            return Integer.compare(b[1],a[1]) ;
        });
        Queue<int [] > q = new LinkedList<>();
        for(int i=0;i<26;i++)
        if(freq[i]!=0) pq.add(new int []{i,freq[i],0}) ;
        int time = 0; String res = "" ;
        while(!pq.isEmpty()|| !q.isEmpty())
        {
            while(!q.isEmpty()&&q.peek()[2]<time)
            {
                pq.offer(q.poll()) ;
            }
            if(!pq.isEmpty())
            {
                int [] nn = pq.poll();
                res = res + (char) ('a' + nn[0]);
                if(nn[1]>1) q.offer(new int []{nn[0],nn[1]-1,time+1}) ;
            }
            time ++;
        }
        return res ;
    }
}