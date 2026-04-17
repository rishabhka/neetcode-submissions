class Solution {
    public int maxProduct(int[] nums) {
        int max = 1 ,min = 1 , global_max = Integer.MIN_VALUE ;
        for(int i=0;i<nums.length;i++)
        {
            int temp = max ;
            max = Math.max(nums[i],Math.max(max*nums[i],min*nums[i]));
            min = Math.min(nums[i],Math.min(temp*nums[i],min*nums[i]));
            System.out.println(max+" "+min);
            if(global_max<max)
            global_max=max;
        }
        return global_max ;
    }
}
