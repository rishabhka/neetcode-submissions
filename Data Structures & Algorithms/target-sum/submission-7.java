class Solution {
    public int f(int[] nums,int current_sum,int target,int i, int dp [][],int range)
    {
        if(i==(nums.length)&&target==current_sum)
        return 1 ;
        else if(i>=nums.length)
        return 0 ;
        else if(dp[i][current_sum+range]!=-1)
        return dp[i][current_sum+range];
        else
        {
        dp[i][current_sum+range] = f(nums,current_sum-nums[i],target,i+1,dp,range) + f(nums,current_sum+nums[i],target,i+1,dp,range) ;
        return dp[i][current_sum+range];
        }
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        if(nums.length==0)
        return 0 ;
        int range = 0;
            for(int i=0;i<nums.length;i++)
            {
            range = range + nums[i] ;
            }
        // if(target<0)
        // {
        //     target = Math.abs(target);
        //     for(int i=0;i<nums.length;i++)
        //     {
        //     nums[i] = nums[i] + target ;
        //     range = range + nums[i] ;
        //     }
        //     target = 0;
        // } else range = target ;
        int [][] dp = new int [nums.length+1][2*range+1] ; // orignal range -> -range + range
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
        return f(nums,0,target,0,dp,range);
    }
}
