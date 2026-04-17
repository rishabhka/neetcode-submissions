class Solution {
    public int f(int[] nums,int current_sum,int target,int i, int dp [][])
    {
        if(i==(nums.length)&&target==current_sum)
        return 1 ;
        else if(i>=nums.length)
        return 0 ;
        else if(i==(nums.length)&&target==0)
        return 1 ;
        // else if(dp[i][current_sum]!=-1)
        // return dp[i][current_sum];
        else
        {
        return f(nums,current_sum-nums[i],target,i+1,dp) + f(nums,current_sum+nums[i],target,i+1,dp) ;
        // return dp[i][current_sum];
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        if(nums.length==0)
        return 0 ;
        int [][] dp = new int [nums.length+1][nums.length+1] ;
        for(int i=0;i<nums.length;i++)
        Arrays.fill(dp[i],-1);
        // for(int i=0;i<nums.length;i++)
        // {
        //     for(int j=0;j<=target;j++)
        //     {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return f(nums,0,target,0,dp);
    }
}
