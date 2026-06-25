class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c :s1.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        int size = s1.length();
        for(int i=0;i<s2.length();i++)
        {
            char c = s2.charAt(i);
            if(map.containsKey(c))
            {
            HashMap<Character,Integer> tempMap = new HashMap<>(map);
            int tempSize = size ;
            int j=i;
                while(j<s2.length()&&tempSize>0&&tempMap.containsKey(s2.charAt(j)))
                {
                    c = s2.charAt(j);
                    if(tempMap.getOrDefault(c,0)==0)
                    break;
                    tempMap.put(c,tempMap.get(c)-1);
                    tempSize--;
                    if(tempSize==0)
                    return true ;
                    j++;
                }
            }
        }
        return false;
    }
}
