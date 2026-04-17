class Solution {
    public void dfs(String s,int i,int j,List<List<String>> result,List<String> list)
    {
        if(j>s.length())
        return ;
        else if(j==s.length())
        {
            if(i==j)
            result.add(new ArrayList<>(list));
            return ;
        }
        else
        {
            boolean take = false;
            String sub = s.substring(i,j+1);
            StringBuilder reverseS = new StringBuilder(sub);
            reverseS.reverse();
            if(reverseS.toString().equals(sub))
            {
            take = true;
            list.add(s.substring(i,j+1));
            dfs(s,j+1,j+1,result,list); // Take that node
            }
            if(take)
            list.remove(list.size()-1);
            dfs(s,i,j+1,result,list);  // Domt take that node and move on

        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s,0,0,result,list);
        for(List<String> l : result)
        {
            for(int i=0;i<l.size();i++)
            System.out.print(l.get(i));
            System.out.println();
        }
        return result;
    }
}
