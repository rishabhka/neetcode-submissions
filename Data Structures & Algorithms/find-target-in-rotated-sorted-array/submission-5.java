class Solution {
    public int minIdx(int [] num,int i,int j)
    {
        if(i==j) return i;
        else
        {
            int mid = (j-i)/2 + i;
            if(num[mid]>num[j])
            return minIdx(num,mid+1,j);
            else
            return minIdx(num,i,mid);
        }
    }
    public int binarySearch(int [] nums,int i,int j,int target)
    {
        if(i>j) return -1;
        else
        {
            int mid = (j-i)/2+i;
            if(nums[mid]==target) return mid ;
            if(nums[mid]>target)
            return binarySearch(nums,i,mid-1,target);
            else
            return binarySearch(nums,mid+1,j,target);
        }

    }
    public int search(int[] nums, int target) {
        int minI = minIdx(nums,0,nums.length-1);
        System.out.println(minI);
        int x = binarySearch(nums,0,minI-1,target);
        int y = binarySearch(nums,minI,nums.length-1,target) ;

        if(x==-1) return y;
        else return x;
        
    }
}
