class Solution {
    public int jump(int[] nums) {
        if(nums.length==0||nums.length==1)
        return 0;
        int start = nums[0];
        int ptr = 0 ;
        int min_length = 0 ; int max = -1; 
        if(start>nums.length-1)
        return 1 ;

        while(start<=nums.length-1)
        {
            min_length ++ ;
            if(ptr+start>=nums.length-1)
            return min_length ;
            for(int i=ptr+1;i<=ptr+start;i++)
            {
                max = Math.max(max,nums[i]);
            }
            ptr = start + ptr ;
            start = max ;
            
            
        }
        return min_length+1 ;
    }
}
