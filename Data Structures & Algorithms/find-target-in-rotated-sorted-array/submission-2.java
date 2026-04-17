class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int i=0;
        int j= n-1;
        if(n==0)
        return -1;
        if(n==1&&nums[0]==target)
        return 0;
        while(i<j)
        {
            int mid = i +  (j -i ) / 2;
            if(nums[j]<nums[mid])
            i = mid +1;
            else
            j = mid;
        }
        int min_index = i;
        
        System.out.println(min_index);
        int bsl = Arrays.binarySearch(nums,min_index,n,target);
        if(bsl>=-1)
        return bsl;
        int bsr = Arrays.binarySearch(nums,0,min_index+1,target);
        if(bsr>-1)
        return bsr;

        return -1;

    }
}
