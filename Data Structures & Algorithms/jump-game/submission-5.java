class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length ;
        int i = n-2 ;
        int target = n-1 ;
        for(;i>=0;)
        {
            System.out.println(i+ " "+target);
            if(nums[i]+i>=target)
            {
                target = i;
                i = target -1 ;
            }
            else 
            i--;
        }
        if(target==0)
        return true;
        else return false;
    }
}
