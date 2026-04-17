class Solution {
    public boolean isAnagram(String s, String t) {

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
}
