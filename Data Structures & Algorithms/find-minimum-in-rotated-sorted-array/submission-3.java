class Solution {
    public int binarySearch(int []nums,int i,int j)
    {
        if(i>j) return -1;
        else
        {
            int mid = (j-i)/2 + i;
            if(nums[mid]>nums[j])
            return binarySearch(nums,mid+1,j) ;
            else if(nums[mid]<nums[i])
            return binarySearch(nums,i,mid) ;
            else if(nums[mid]>nums[i])
            return i;
            return mid ;
        }

    }
    public int findMin(int[] nums) {
        int start = binarySearch(nums,0,nums.length-1);
        return nums[start];
    }
}
