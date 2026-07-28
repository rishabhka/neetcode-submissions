class Solution {
    public int candy(int[] nums) {
        int [] candies = new int [nums.length] ;
        candies [0] = 1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]==nums[i])
            {
                candies[i] = 1;
            }
            else if(nums[i-1]<nums[i])
            {
                candies[i] =candies[i-1] + 1 ; 
            }
            else
            {
                if(candies[i-1]==1)
                {
                    candies[i-1] = 2;
                    candies[i] = 1;
                }
                else candies[i] = 1;
            }

        }
        for(int i = nums.length-1;i>=1;i--)
        {
            if(nums[i-1]>nums[i])
            candies[i-1] = Math.max(candies[i-1],candies[i] + 1);
        }
        int sum =0;
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(candies[i]+" ");
            sum = sum + candies[i] ;
        }
        return sum ;

    }
}