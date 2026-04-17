class Solution {
    public int minJump(int [] nums,int i,int [] dp)
    {
        if(i>=nums.length-1)
        return 0 ;
        else if(dp[i]!=-1)
        return dp[i];
        // else if(i>nums.length)
        // return Integer.MAX_VALUE/2 ;
        else
        {
            int min = Integer.MAX_VALUE/2 ;
            for(int j=1;j<=nums[i];j++)
            {
                min = Math.min(min,minJump(nums,i+j,dp)+1);
            }
            dp[i] = min ;
            return dp[i];
        }

    }
    public int jump(int[] nums) {
        int [] dp = new int [nums.length+1];
        Arrays.fill(dp,-1);
        return minJump(nums,0,dp);
    }
}
