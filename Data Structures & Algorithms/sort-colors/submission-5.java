class Solution {
    public void swap(int [] nums,int p,int q)
    {
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
    public int sort(int [] nums, int p , int q,int val)
    {
        int r = q ;
        while(p<q)
        {
            if(nums[q]==val)
            {
                q--; r-- ;
            }
            else
            {
                if(nums[p]==val)
                {
                swap(nums,p,q);
                p++ ; q -- ; r-- ;
                }
                else
                {
                    p++;
                }
            }
        }
        while(r>=0&&nums[r]==val)
        r--;
        return r ;
    }
    public void sortColors(int[] nums) {
        int p = 0 ; int q = nums.length-1; 
        int r = sort(nums,0,q,2) ;
        System.out.println(r);
        sort(nums,0,r,1) ;
    }
}