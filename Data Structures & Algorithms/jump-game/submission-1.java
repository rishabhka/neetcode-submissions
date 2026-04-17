class Solution {
    public boolean jump(int [] nums , int i)
    {
        if(i>nums.length)
        return false;
        else if(i==nums.length-1)
        return true ;
        else
        {
            boolean jumpi = false;
            for(int j = 1;j<=nums[i];j++)
            jumpi = jumpi || jump(nums,j+i); 
            return jumpi;
        }
    }
    public boolean canJump(int[] nums) {
        int i =0;
        return jump(nums,0);
    }
}
