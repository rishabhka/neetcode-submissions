class Solution {
    public int binarySearch(int [] nums,int i,int j,int target)
    {
        if(i>j) return -1;
        else
        {
            int mid = (j-i)/2+i ;
            if(nums[mid]==target)
            return mid ;
            else if(nums[mid]>nums[j]&&target<=nums[j])
            return binarySearch(nums,mid+1,j,target);
            else if(nums[mid]<nums[i]&&target>=nums[i])
            return binarySearch(nums,0,mid-1,target);
            else if(nums[mid]<target)
            return binarySearch(nums,mid+1,j,target);
            else
            return binarySearch(nums,0,mid-1,target);
        }
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
}
