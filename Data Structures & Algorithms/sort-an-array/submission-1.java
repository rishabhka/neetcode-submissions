class Solution {
    public void swap(int [] nums,int i ,int j) 
    {
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
    public int partition(int [] nums,int low,int high) 
    {
        int pivot = high ;
        int i = low  -1 ;
        for(int j = low;j<high ;j++)
        {
            if(nums[j]<nums[pivot])
            {
                i++ ;
                swap(nums,i,j) ;
            }
        }
        swap(nums,i+1,pivot) ;
        return i +1 ;

    }
    public void  QuickSort(int [] nums,int i,int j) 
    {
        if(i<j)
        {
            int p = partition(nums,i,j) ;
            QuickSort(nums,i,p-1) ;
            QuickSort(nums,p+1,j) ;
        }
    }
    public int[] sortArray(int[] nums) {
        QuickSort(nums,0,nums.length -1) ;
        return nums ;
    }
}