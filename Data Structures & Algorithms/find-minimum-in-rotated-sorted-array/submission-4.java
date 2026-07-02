class Solution {
    public int binarySearch(int []nums,int i,int j)
    {
        if(i==j) return i;
        else
        {
            int mid = (j-i)/2 + i;
            if(nums[mid]>nums[j])
            return binarySearch(nums,mid+1,j) ;
            else
            return binarySearch(nums,i,mid) ;
        }

    }
    public int findMin(int[] nums) {
        int start = binarySearch(nums,0,nums.length-1);
        return nums[start];
    }
}
