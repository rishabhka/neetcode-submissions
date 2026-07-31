class Solution {
    public boolean partition(int [] nums,int i,int target) 
    {
        if(target == 0) return true ;
        else if(target <0 || i==nums.length) return false;
        else
        {
            return partition(nums,i+1,target-nums[i]) || partition(nums,i+1,target) ;
        }

    }
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for(int num :nums) sum = sum + num ;
        if(sum%2!=0) return false;
        sum = sum /2 ;
        return partition(nums,0,sum) ;
    }
}
