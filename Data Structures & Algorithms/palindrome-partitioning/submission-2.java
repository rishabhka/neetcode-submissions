class Solution {
	public boolean pal(String s)
	{
	int i =0; int j = s.length()-1;
	while(i<j)
	{
	if(s.charAt(i)!=s.charAt(j)) return false;
	i++ ; j --;
	}
	return true ;
	}
	public void dfs(String s,List<String> temp,int i,List<List<String>> res)
	{
		if(i==s.length()) res.add(new ArrayList<>(temp)) ;
		else
		{
		for(int j=i+1;j<=s.length();j++)
		{
		String sub = s.substring(i,j) ;
		if(pal(sub))
		{
		temp.add(sub);
		dfs(s,temp,j,res) ;
		temp.remove(temp.size()-1) ;
		}
		}
		}
	}
	
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		dfs(s,temp,0,res) ;
		return res ;
    }
}