class Solution {
    public int characterReplacement(String s, int k) {
        int n= s.length();
        int p=0; int q=0;
        int [] freq = new int [26];
        int max_freq = 0;
        int max_len = 0;
        // freq[s.charAt(p)-'A'] = 1 ;
        while(q<n)
        {
            freq[s.charAt(q)-'A'] = freq[s.charAt(q)-'A'] + 1 ;
            if(freq[s.charAt(q)-'A']>max_freq)
            max_freq = freq[s.charAt(q)-'A'];
            while(q-p+1-max_freq>k)
            {
                freq[s.charAt(p)-'A']--;
                p++;
                // max_freq = freq[p];
            }
            if(q-p+1>max_len)
            max_len = q-p+1;
            q++;
        }
        return max_len ;
        
    }
}
