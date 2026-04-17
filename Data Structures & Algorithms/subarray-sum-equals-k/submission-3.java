class Solution {
    public int subarraySum(int[] nums, int k) {
        // int local = 0 ;
        int global = 0 ;
        for(int i=0;i<nums.length;i++)
        {
        int local = nums[i];
        if(local == k)
        global++ ;
        for(int j=i+1;j<nums.length;j++)
        {
        local = local + nums[j];
        if(local == k)
        global++ ; 
        }
        
        }
        return global ;
        
    }
}