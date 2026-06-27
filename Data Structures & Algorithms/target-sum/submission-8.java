class Solution {
    public int ways(int[] nums,int i,int target)
    {
        if(i==nums.length&&target==0)
        return 1;
        else 
        if(i>=nums.length) return 0;

        return ways(nums,i+1,target+nums[i]) + ways(nums,i+1,target-nums[i]);


    }
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==0)
        return 0 ;

        return ways(nums,0,target);
    }
}
