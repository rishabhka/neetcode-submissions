class Solution {
    public int jump(int[] nums) {
        if(nums.length==0||nums.length==1)
        return 0;
        int furthest = 0 ; int start = 0; int end  =0; int count = 0;
        for(int i=0;i<nums.length-1;i++)
        {
            furthest = Math.max(furthest,i+nums[i]);
            
            if(i==end) 
            {
                count ++ ;
                end = furthest ; 
            }
        }
        return count ;
    }
}
