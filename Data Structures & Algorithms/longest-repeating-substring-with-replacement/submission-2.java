class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0 ; int result =0;
        int p=0; int q=0;
        while(q<s.length())
        {
          char currChar = s.charAt(q);
          map.put(currChar,map.getOrDefault(currChar,0)+1) ;
          if(maxFreq<map.get(currChar))
          maxFreq = map.get(currChar) ;

          while(q-p+1-maxFreq>k)
          {
            map.put(s.charAt(p),map.get(s.charAt(p))-1) ;
            p++;
          }
          if(q-p+1>=result)
          result = q-p+1;

          q++;

          System.out.println(s.substring(p,q));

        }
        return result ;
    }
}
