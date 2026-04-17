class Solution {
    public int f(int[] nums,int target,int i)
    {
        if(i==(nums.length)&&target==0)
        return 1 ;
        else if(i>=nums.length)
        return 0 ;
        else if(i==(nums.length)&&target==0)
        return 1 ;
        else
        return f(nums,target-nums[i],i+1) + f(nums,target+nums[i],i+1) ;
    }
    public int findTargetSumWays(int[] nums, int target) {
        
        if(nums.length==0)
        return 0 ;
        return f(nums,target,0);
    }
}
