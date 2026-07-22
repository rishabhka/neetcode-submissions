class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] prefix = new int [nums.length]; int curr = 1;
        for(int i=0;i<nums.length;i++)
        {
            prefix[i] = curr ;
            curr = curr * nums[i] ;
        } curr =1;
        for(int i=nums.length-1;i>=0;i--)
        {
            prefix[i] = prefix[i] * curr ;
            curr = curr * nums[i] ;
        }
        return prefix ;
        
    }
}  
