class Solution {
    // 1 ,2 , 3
    public int sum (int [] nums,int target,int [] res,int [] dp)
    {
        if(target==0)
        return 1;
        else if(target<0)
        return 0;
        else if(dp[target]!=-1)
        return dp[target];
        else
        {
            int total =0;
            for(int i=0;i<nums.length;i++)
            {
            total = total +sum (nums,target-nums[i],res,dp);
            }
            dp[target] = total ;
            return dp[target];
        }

    }
    public int combinationSum4(int[] nums, int target) {
        int [] res = new int[1];
        int [] dp = new int[target +1];
        Arrays.fill(dp,-1);
        return sum (nums,target,res,dp);
        // return res[0];
    }
}