class Solution {
    public int f(int[] nums,int i,int prev)
    {
        if(i>=nums.length)
        return 0;
        else
        {
            if(nums[i]>prev)
            return Math.max(f(nums,i+1,nums[i]) + 1,f(nums,i+1,prev)) ;
            else return f(nums,i+1,prev) ;
        }
    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1)
        return nums.length ;
        int prev = Integer.MIN_VALUE ;
        return f(nums,0,prev);
    }
}
