class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0] ; int min = nums[0] ; int total_max = nums[0] ;
        for(int i=1;i<nums.length;i++)
        {
            int x = nums[i] * max ;
            int y = nums[i] * min ;
            max = Math.max(nums[i],Math.max(x,y)) ;
            min = Math.min(nums[i],Math.min(x,y)) ;
            total_max = Math.max(total_max,max) ;
        }
        return total_max ;
    }
}
