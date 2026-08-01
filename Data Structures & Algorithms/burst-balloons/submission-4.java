class Solution {
    //[4,2,3,7]
    // //[1,4,2,3,7,1]
    public int dfs(int [] nums,int p , int q,int [][] dp)
    {
        if(p==q-1) return 0;
        else if(dp[p][q]!=-1) return dp[p][q] ;
        else
        {
        int max = 0;
        for(int j=p+1;j<q;j++)
        max = Math.max( dfs(nums,p,j,dp)+ nums[j] * nums[p] * nums[q]+ dfs(nums,j,q,dp) , max );
        dp[p][q]= max ;
        return dp[p][q] ;
        }
    }
    public int maxCoins(int[] nums) {
        int [] arr =new int[nums.length+2] ; int max = 0;
        arr[0] = 1 ; arr[nums.length+1] = 1 ;
        int [][] dp = new int [nums.length+2][nums.length+2] ;
        for(int i=0;i<arr.length;i++)
        Arrays.fill(dp[i],-1) ;
        for(int i=0;i<nums.length;i++)
        arr[i+1] = nums[i] ;
        return dfs(arr,0,nums.length+1,dp) ;
        
    }
}
