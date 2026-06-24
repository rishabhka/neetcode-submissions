class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zero = 0; int p =1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0) p = p * nums[i] ;
            else zero ++;
        }
        int [] result = new int[nums.length];
        if(zero>1)
        return result;
        else if(zero==1)
        {
            for(int i=0;i<nums.length;i++)
            if(nums[i]==0) result[i] = p;
        }
        else
        {
            for(int i=0;i<nums.length;i++)
            result[i] = p/nums[i];
        }
        return result;
    }
}  
