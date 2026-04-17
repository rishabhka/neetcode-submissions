class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int p = 0 , q = 0;
        int sum = 0;
        int min_len = Integer.MAX_VALUE ; int i = 0 ; int j= 0;
        while(q<nums.length)
        {  
            if(sum<target)
            {
            sum = sum + nums[q] ;
            if(sum>=target&&(q-p+1)<min_len)
            {            
                i = p;
                j = q ;
                min_len = q-p+1;
                System.out.println("q "+i+" "+j);
            }
            }
            while(sum>=target&&p<=q)
            {
                sum = sum - nums[p] ;
                p++;
                if(sum>=target&&(q-p+1)<min_len)
            {
                i = p;
                j = q ;
                min_len = q-p+1;
                System.out.println("p "+i+" "+j);
            }
                
            }
            q++;
            System.out.println(sum);          
        }
        return min_len==Integer.MAX_VALUE?0:min_len;
    }
}