class Solution {
    public List<Integer> partitionLabels(String s) {
        int start = 0 ;
        // if(s.length<=1)
        // return s.length ;
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<s.length();i++)
        map.put(s.charAt(i),i) ;
        // q.add(s.charAt(0));
        int last_idx = 0; 
        for(int i=0;i<s.length();)
        {
            q.add(s.charAt(i));
            // System.out.println(s.charAt(i));
            start = i ;
            while(!q.isEmpty())
            { 
            char letter = q.poll();
            last_idx = map.get(letter) ;
            if(last_idx<i)
            continue ;
            System.out.println(i+" "+last_idx);
            for(int j = i ;j<=last_idx;j++)
            {
                if(s.charAt(j)!=letter)
                {
                q.add(s.charAt(j)) ;
                }
            }
            i = last_idx + 1 ;
            }
            result.add(i-start);
        }
        return result ;
    }
}
