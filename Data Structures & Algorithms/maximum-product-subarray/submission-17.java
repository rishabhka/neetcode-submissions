class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0)
        return 0;
        if(nums.length==1)
        return nums[0];
        int max = Integer.MIN_VALUE /2;
        int curr_max = nums[0];
        int curr_min = nums[0];

        for(int i=1;i<nums.length;i++)
        {
           int temp = curr_min;
           curr_min = Math.min(nums[i],Math.min(curr_min*nums[i],
           curr_max*nums[i])) ; 
           curr_max= Math.max(nums[i],Math.max(temp*nums[i],
           curr_max*nums[i])) ;
            if(curr_max>max)
            max = curr_max;
        }
        return max;
    }
}
