class Solution {
    Trie root ;
    public class Trie 
    {
        Trie [] mapping ;
        Boolean isEnd ;
        Trie()
        {
            mapping = new Trie [26];
            isEnd = false;   
        }
    }
    public  int f(String s,int i,String [] set,int [] dp)
    {
        if(i>=s.length())
            return 0;
        else if(dp[i]!=-1)
            return dp[i]; 
        else
        {
            int p = 1+f(s,i+1,set,dp)    ;    //skip
            int q = Integer.MAX_VALUE ;
            Trie temp = root ;
            for(int j=i;j<s.length();j++)
            {
                int curr = s.charAt(j) - 'a' ;
                if(temp.mapping[curr]==null)
                break ;
                else temp = temp.mapping[curr] ;
                if(temp.isEnd)
                q = Math.min(q,f(s,j+1,set,dp))    ;   // Take
            }
            
            // }
            dp[i] = Math.min(p,q);
            return dp[i];
        }

    }
    public int minExtraChar(String s, String[] dictionary) {
        int [] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        root = new Trie();
        for(String word : dictionary )
            insert(word);
        return f(s,0,dictionary,dp);
        }
        public void insert(String word) {
        Trie temp = root ;
        int curr = 0 ; 
        while(curr!=word.length()){
            int curr_charr = word.charAt(curr)-'a';
            if(temp.mapping[curr_charr]==null)
            {   
                Trie new_node = new Trie();
                temp.mapping[curr_charr] = new_node ;
            }
            temp = temp.mapping[curr_charr];
            curr++;
        }
        temp.isEnd = true ;
    }
}