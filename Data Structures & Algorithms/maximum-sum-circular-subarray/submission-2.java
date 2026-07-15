class Solution {
    //[5,-3,5]
    //[-2,4,-5,4,-5,9,4]
    public int maxSubarraySumCircular(int[] nums) {
        int local_p = 0 ; int global = Integer.MIN_VALUE ; int local_n = 0;
        int n = nums.length ; int last =0; int global_n = Integer.MAX_VALUE ;
        int total =0;
        for(int i=0;i<nums.length;i++)
        {
             total = total + nums[i] ;
            local_p = local_p + nums[i] ;
            local_n = local_n + nums[i] ;
            if(local_p>global)
            global = local_p ;

            if(local_n<global_n)
            global_n = local_n;

            if(local_p<0)
            local_p =0 ;
            if(local_n>0)
            local_n =0 ;
        }
        System.out.println(global + " " +global_n ) ;
        if(total>0)
        return Math.max(total-global_n,global);
        else
        return global;
        
    }
}