class Solution {
    public int binarySearch(int [] nums , int target , int i , int j)
    {
        if(i>j)
        return -1 ;
        else
        {
            int mid = (j-i) /2 + i ;
            if(nums[mid]==target)
            return mid ;
            else if(nums[mid]<target)
            return binarySearch(nums,target,mid+1,j);
            else
            return binarySearch(nums,target,i,mid-1);
        }
    }
    public int search(int[] nums, int target) {
        int n= nums.length;
        if(n==0)
        return -1 ;
        else
        {
            return binarySearch(nums,target,0,n-1);
        }
    }
}
