class Solution {
    public int f(int [] nums,int i,int prev)
    {
        if(i>=nums.length)
        return 0 ;
        else
        {
            if(prev!=-1&&nums[i]<=nums[prev]) // skip
            return f(nums,i+1,prev);
            else
            return Math.max(f(nums,i+1,prev) ,f(nums,i+1,i)+1);
        }
        

    }
    public int lengthOfLIS(int[] nums) {
        if(nums.length<=1)
        return nums.length;
        
        return f(nums,0,-1) ;
    }
}
