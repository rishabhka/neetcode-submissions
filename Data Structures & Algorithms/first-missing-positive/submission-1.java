class Solution {
    public void swap(int [] nums , int i,int j)
    {
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length ;
        for(int i=0;i<n;i++)
        {
        while(i<n&&nums[i]>0&&nums[i]<=n&&i!=nums[i]-1&&nums[i] != nums[nums[i] - 1])
            {
             if(i==nums[i]-1)
             break ;
             swap(nums,i,nums[i]-1);
             
            //  i++ ;      
            }
        }
         for(int j=0;j<n;j++)
        {
            System.out.print(nums[j]+ " ");
        }   
        for(int j=0;j<n;j++)
        {
            if(nums[j]!=(j+1))
            return j+1 ;
        }
        return n+1 ;
    }
}