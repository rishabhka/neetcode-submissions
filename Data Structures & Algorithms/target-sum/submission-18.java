class Solution {
    public int findWays(int [] nums,int i,int curr,int target)
    {
        if(nums.length==i&&target==curr) return 1 ;
        else if(i>=nums.length) return 0;
        else
        {
            return  findWays(nums,i+1,curr + nums[i],target) + findWays(nums,i+1,curr - nums[i],target) ;
        }

    }
    public int findTargetSumWays(int[] nums, int target) {
        return findWays(nums,0,0,target) ;
    }
}
