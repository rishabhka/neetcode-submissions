class Solution {
    public void swap(int [] nums ,int p,int q)
    {
        int temp = nums[p];
        nums[p]=nums[q];
        nums[q]=temp;
    }
    public void sortColors(int[] nums) {
        int p=0 ;
        int q = nums.length-1 ;
        if(q+1<2)
        return ;
        while(p<q)
        {
            if(nums[q]==0)
            {
                if(nums[p]!=0)
                {
                    swap(nums,p,q);
                    p++; 
                    q-- ;
                }
                else
                p++ ;
            }
            else q -- ;
        }
        System.out.println(p+" "+ q) ;
        // p ++ ;
        q = nums.length-1 ;
        while(p<q)
        {
            if(nums[q]==1)
            {
                if(nums[p]!=1&&nums[p]!=0)
                {
                    swap(nums,p,q);
                    p++; 
                    q-- ;
                }
                else
                p++ ;
            }
            else q -- ;
        }
        return ;
    }
}