class Solution {
    public int binarySearch(int [] nums,int i,int j,int target)
    {
        if(i>j) return -1;
        int mid = (i+j)/2;
        if(nums[mid]==target)
        return mid;
        else if(nums[mid]<target)
        return binarySearch(nums,mid+1,j,target);
        else
        return binarySearch(nums,i,mid-1,target);
    }
    public int search(int[] nums, int target) {
        int i = 0; 
        int j= nums.length-1;
        return binarySearch(nums,i,j,target);
    }
}
