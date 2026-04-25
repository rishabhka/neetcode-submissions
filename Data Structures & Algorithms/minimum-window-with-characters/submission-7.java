class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
        return "";
        int result = Integer.MAX_VALUE ;
        // if in HM all are 0s -> Then take dist
        int p=0 ; int q= 0; int glob_p =0 ; int glob_q=0;
        HashMap<Character,Integer> max_freq = new HashMap<>() ;
        HashMap<Character,Integer> curr_freq = new HashMap<>() ;
        for(char c :t.toCharArray())
        {
            max_freq.put(c,max_freq.getOrDefault(c,0)+1);
            curr_freq.put(c,curr_freq.getOrDefault(c,0)+1);
        }
        int need = curr_freq.size();
int match = 0;
        while(q<s.length()&&p<s.length())
        {
            if(curr_freq.containsKey(s.charAt(q))) {
    curr_freq.put(s.charAt(q), curr_freq.get(s.charAt(q)) - 1);
    if(curr_freq.get(s.charAt(q)) == 0) match++;
}
            
            while(match==need)
            {
                if(q-p+1<result)
                {
                System.out.println("Window: " + s.substring(p, q+1));
                System.out.println("curr_freq after: " + curr_freq + " p="+p+" q="+q+" match="+match);
                glob_p= p;
                glob_q=q;
                result = q-p+1;
                }
                if(curr_freq.containsKey(s.charAt(p))) {
        curr_freq.put(s.charAt(p), curr_freq.get(s.charAt(p)) + 1);
        if(curr_freq.get(s.charAt(p)) == 1) match--;
    }
    p++;
            }
            q++;
        }
        return result == Integer.MAX_VALUE ? "" : s.substring(glob_p, glob_q + 1);
    }
}
