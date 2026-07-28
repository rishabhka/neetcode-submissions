class Solution {
    class Trie {
        Trie [] neigh ; boolean isEnd ;
        Trie () {
            neigh = new Trie[26] ;
        }
    }
    Trie root ;
    public void insert(String w)
    {
        Trie temp = root ;
        for(char ch : w.toCharArray())
        {
            if(temp.neigh[ch-'a']==null)
            {
                Trie node = new Trie();
                temp.neigh[ch-'a'] = node ;
            }
            temp = temp.neigh[ch-'a'] ;
        }
        temp.isEnd = true ;
    }
    // public boolean search (String w)
    // {
    //     Trie temp = root ;
    //     for(char ch : w.toCharArray())
    //     {
    //         if(temp.neigh[ch-'a']==null) return false;
    //         else
    //         temp = temp.neigh[ch-'a'] ;
    //     }

    //     if(temp.isEnd == true) return true ;
    //     else return false;
    // }
    public int dfs(String s,int i,int [] memo)
    {   int n = s.length();
        if(i==s.length()) return 0 ;
        else if(memo[i]!=-1) return memo[i] ;
        else
        {
            int notTake = dfs(s,i+1,memo) +1  ; int take = Integer.MAX_VALUE ;
            Trie temp = root ;
            for(int j=i;j<n;j++)
            {
                if(temp.neigh[s.charAt(j)-'a']==null) break ;
                else 
                {
                    temp = temp.neigh[s.charAt(j)-'a'] ;
                    if(temp.isEnd==true)
                    take = Math.min(take, dfs(s,j+1,memo) ) ;
                }
            }
            memo[i]= Math.min(take,notTake) ;
            return memo[i] ;
        }

    }
    public int minExtraChar(String s, String[] dictionary) {
        root = new Trie();
        for(int i=0;i<dictionary.length;i++)
        insert(dictionary[i]) ;
        int [] memo = new int [s.length()] ;
        Arrays.fill(memo,-1) ;
        return dfs(s,0,memo) ;
    }
}