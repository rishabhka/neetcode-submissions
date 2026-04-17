class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0)
        return 0 ;
        int local = nums[0] , global = nums[0] ;

        for(int i=1;i<nums.length;i++)
        {
            
            System.out.println(local);
            if(local>global)
            global = local; 
            
            if(local+nums[i]>nums[i])
            local = local+nums[i];
            else
            local = nums[i] ;

        }
        if(local>global)
        global = local; 
        return global; 
        
    }
}
