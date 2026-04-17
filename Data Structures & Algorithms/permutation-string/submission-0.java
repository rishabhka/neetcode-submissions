class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i =0 , counter =0 , j=0;
        while(i<s1.length())
        {
            char x = s1.charAt(i);
            if(map.containsKey(x))
            map.put(x,map.get(x)+1);
            else
            map.put(x,1);
            i++;
        }
        i=0;
        while(j<s2.length())
        {
            if(counter==s1.length())
            return true;
            char x = s2.charAt(j);
            char y = s2.charAt(i);
            if(!map.containsKey(x))
            {
                while(i!=j)
                {
                    if(map.containsKey(s2.charAt(i)))
                    {
                    map.put(s2.charAt(i),map.get(s2.charAt(i))+1);
                    counter -- ;
                    }
                    i++;
                }
                j++;
            }
            else
            {
                if(map.get(x)==0){
                    if(map.containsKey(y))
                    {
                    map.put(y, map.get(y) + 1);
                    counter--;
                    }
                    i++;
                } else
                {
                    map.put(x,map.get(x)-1);
                    j++;
                    counter++;
                }
            }

        }
        if(counter==s1.length())
        return true;
        else
        return false;
    }
}

