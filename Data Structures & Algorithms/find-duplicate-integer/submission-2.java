class Solution {
    // [1,2,3,2,4]
    // [1,2,2,3,4]
    public void swap(int []nums, int i ,int j)
    {
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==i+1) continue ;
            else if(nums[nums[i]-1]==nums[i]) return nums[i];
            else swap(nums,i,nums[i]-1) ;  
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]-1!=i) return nums[i];
        }
        return -1 ;
    }
}
