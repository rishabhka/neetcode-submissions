class Solution {
    int count =0 ;
    public int f(int n,List<Integer> list,int i,int dp [][])
    {
        if(n==0) return 0;
        if(i<0||n<0) return 100000;
        int curr_el = list.get(i);
        if(dp[n][i]!=-1)
        return  dp [n][i];
        dp [n][i]= Math.min(f(n-curr_el*curr_el,list,i,dp)+1,f(n,list,i-1,dp)) ; 
        return dp [n][i]; 
    }
    public int numSquares(int n) {
        if(n==1||n==0)
        return n;
        int x= 1;
        List<Integer> result = new ArrayList<>();
        while(x*x<=n)
        {
        result.add(x);
        x++;
        }
        int dp [][] = new int [n+1][result.size()] ;
        for(int i=0;i<dp.length;i++)
        Arrays.fill(dp[i],-1);
        return f(n,result,result.size()-1,dp);
    }
}