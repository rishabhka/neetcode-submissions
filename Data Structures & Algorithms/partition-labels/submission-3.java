class Solution {

    public List<Integer> partitionLabels(String s) {
        HashMap<Character,int[]> map = new HashMap<>();
        List<int[]> list = new ArrayList<>(); // we will get sorted list
        List<int[]> result = new ArrayList<>(); // we will get sorted list
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i) ;
            if(!map.containsKey(ch))
            {
            int [] node = new int [3];
            node[0] = i; 
            node[1] = i; 
            node[2] = list.size() ;   
            map.put(ch,node);
            list.add(node);
            }
            else
            {
            int [] node = map.get(ch) ;
            node[1] = i;
            list.get(node[2])[1] = i;
            map.put(ch,node);
            }
        }
        int [] start = list.get(0);
        for(int i=1;i<list.size();i++)
        {
            int [] curr = list.get(i) ;
            if(curr[0]<start[1])
            start[1] = Math.max(start[1],curr[1]);
            else
            {
                result.add(start);
                start = curr ;
            }

        }
        result.add(start);
        List<Integer> x = new ArrayList<>();
        for(int i=0;i<result.size();i++)
        {
            x.add(result.get(i)[1]-result.get(i)[0]+1);
        }
        return x;
    }
}
