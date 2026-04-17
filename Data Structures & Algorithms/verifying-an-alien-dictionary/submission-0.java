class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length<2)
        return true ;
        HashMap<Character,Integer> map = new HashMap<>();
        int count =0;
        for(char c: order.toCharArray())
        {
            map.put(c,count);
            count ++;
        }
        int i=0;
        while(i+1<words.length)
        {
            String word1 = words[i];
            String word2 = words[i+1];
            int j=0 ;
            for(;j<Math.min(word1.length(),word2.length());j++)
            {
                if(map.get(word1.charAt(j))==map.get(word2.charAt(j)))
                continue ;
                if(map.get(word1.charAt(j))<map.get(word2.charAt(j)))
                break ;
                else
                return false ;

            }
            if(j==Math.min(word1.length(),word2.length()))
            {
                if(word1.length()>word2.length())
                return false ;
            }
            i++;
        }
        return true ;


    }
}