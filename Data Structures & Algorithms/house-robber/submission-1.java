class Solution {
    // public int f(int [] nums , int i , int [] dp,int profit)
    // {
    //     if(i>=nums.length)
    //     return 0;
    //     else if(dp[i]!=-1)
    //     return dp[i];
    //     else
    //     {
    //      int skip = f(nums,i+1,dp,profit);
    //      int take = f(nums,i+2,dp,profit) + nums[i] ;
    //      dp[i] = Math.max(skip,take);
    //      return dp[i];
    //     }
        
    // }
    public int rob(int[] nums) {
        if(nums.length==0)
        return 0;
        else if (nums.length==1)
        return nums[0];
        int skip2 =nums[nums.length-1];
        int skip1 =Math.max(nums[nums.length-1],nums[nums.length-2]);
        nums[nums.length-2] = Math.max(nums[nums.length-1],nums[nums.length-2]);
        if(nums.length==2)
        return(Math.max(skip1,skip2));
        for(int i=nums.length-3;i>=0;i--)
        {
            skip1 = nums[i+1];
            skip2 = nums[i+2]+nums[i];
            nums[i] = Math.max(nums[i+1],nums[i+2]+nums[i]);
            
        }
        return nums[0];
    }
}
