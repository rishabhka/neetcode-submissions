class Solution {
    public boolean reachTop(int [] nums,int i)
    {
        if(i>=nums.length-1) return true;
        else if(nums[i]==0) return false;
        boolean flag = false;
        for(int j=1;j<=nums[i];j++)
        { 
            if(j>nums.length) return true;
            else
            flag = flag || reachTop(nums,i+j);
            if(flag)
            return true;
        }
        return false;

    }
    public boolean canJump(int[] nums) {
        return reachTop(nums,0);
    }
}
