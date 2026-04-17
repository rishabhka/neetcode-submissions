class Solution {
    public int maxProduct(int[] nums) {
        int max_value = 1;
        int min_value = 1;
        int global = Integer.MIN_VALUE ;
        for(int i=0;i<nums.length;i++)
        {
            int temp = max_value;
            max_value = Math.max(nums[i],Math.max(max_value*nums[i],min_value*nums[i]));
            min_value = Math.min(nums[i],Math.min(temp*nums[i],min_value*nums[i]));
            if(max_value>global)
            global=max_value;
        }
        return global;
    }
}
