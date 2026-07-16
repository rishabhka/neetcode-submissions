class Solution {
    public int occupied(int [] nums,int mid)
    {
        int sum =0 ; int count =0;
        for(int i=0;i<nums.length;i++)
        {
            sum = sum + nums[i];
            if(sum>mid)
            {
                sum = nums[i] ;
                count ++;
            }
        }
        return count+1 ;
    }
    public int splitArray(int[] nums, int k) {
        int i =Integer.MIN_VALUE ; int j = 0;
        for(int l=0;l<nums.length;l++)
        {
            i = Math.max(i,nums[l]);
            j = j + nums[l] ;
        }
        while(i<j)
        {
            if(i>=j) return i ;
            else
            {
                int mid = (j-i)/2 + i ;
                if(occupied(nums,mid)<=k) // right
                j = mid  ;
                else i = mid+1 ;
            }
        }
        return i ;
    }
}