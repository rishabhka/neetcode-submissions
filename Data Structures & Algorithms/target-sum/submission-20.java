class Solution {
    public int findWays(int [] nums,int i,int curr,int target,int [][] memo,int total)
    {
        if(nums.length==i&&target==curr) return 1 ;
        else if(i>=nums.length) return 0;
        else if(memo[i][curr+total]!=-1) return memo[i][curr+total] ;
        else
        {
            memo[i][curr+total]=  findWays(nums,i+1,curr + nums[i],target,memo,total) + findWays(nums,i+1,curr - nums[i],target,memo,total) ;
            return memo[i][curr+total] ;
        }

    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0 ;
        for(int i=0;i<nums.length;i++)
        sum = sum + nums[i] ;
        int [][] memo = new int[nums.length][2*sum+1] ;
        for(int i=0;i<nums.length;i++)
        Arrays.fill(memo[i],-1) ;
        return findWays(nums,0,0,target,memo,sum) ;
    }
}
