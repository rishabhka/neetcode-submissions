class Solution {
 // 2,2
 
	public void  dfs(int left,int right ,String temp,List<String> res,int n) 
	{
		if(right>left||left>n||right>n) return ;
		else if(left==n&&right==n) res.add(temp) ;
		else if(right>left||left>n||right>n) return ;
		else
		{
		dfs(left+1,right,temp+"(",res,n) ;
		dfs(left,right+1,temp+")",res,n) ;
		 }
	}
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
		String temp = "" ;
		dfs(0,0,temp,res,n) ;
		return res ;
    }
}
