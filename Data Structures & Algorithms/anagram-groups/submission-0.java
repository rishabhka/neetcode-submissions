class Solution {

   public Boolean checkAnagaram(String s,String t)
   {
    if(s.length()!=t.length())
        return false;

    HashMap<Character,Integer> map = new HashMap<>();
    
    for(char i : s.toCharArray())
    {
     if(map.containsKey(i))
     map.put(i,map.get(i)+1);
     else 
     map.put(i,1);
    }
    for(char j : t.toCharArray())
    {
        if(map.containsKey(j))
        {
            if(map.get(j)==1)
            map.remove(j);
            else
            map.put(j,map.get(j)-1);
        }
    }
    if(map.size()==0)
    return true;
    else
    return false;
   }


    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        int n = strs.length;
        int [] visited = new int [n] ;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
            List<String> list = new ArrayList<>();
            visited [i] = 1;
            list.add(strs[i]);
            for( int j= i+1 ;j< n;j++)
            {
                if(checkAnagaram(strs[i],strs[j]))
                {
                    list.add(strs[j]);
                    visited[j] = 1;
                }
            }
            result.add(list);
            }

        }
        return result;

    }
}
