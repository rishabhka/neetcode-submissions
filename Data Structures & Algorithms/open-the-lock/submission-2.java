class Solution {
    public List<String> list(String s)
    {
        List<String> res = new ArrayList<>();
        char [] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            int num = ch[i] - '0' ;
            int next = (num + 1)%10 ;
            int prev = num-1<0?9:num-1 ;
            ch[i] = (char)(next+ '0')  ;
            res.add(new String(ch)) ;
            ch[i] = (char)(prev+ '0')  ;
            res.add(new String(ch)) ;
            ch[i] = (char)(num+'0') ;
        }
        return res;

    }
    public int openLock(String[] deadends, String target) {
        HashSet<String> visited = new HashSet<>();
        for(String s :deadends )
        visited.add(s) ;
        if (visited.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>(); int time = 0;
        q.offer("0000") ;
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i=0;i<size;i++)
            {
            String node = q.poll() ;
            if(target.equals(node)) return time ;
            for(String s : list(node))
            {
            if(visited.contains(s)) continue ;
            visited.add(s) ;
            q.offer(s) ;
            }     
            }        
            time ++;
        }
        return -1 ;

    }
}