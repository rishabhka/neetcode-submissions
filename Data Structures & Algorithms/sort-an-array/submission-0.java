class Solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int partition(int [] nums,int low,int high)
    {
        int p = nums[high] ;
        int i = low-1;
        for(int j=low;j<high;j++)
        {
            if(p>nums[j])
            {
                i++;
                swap(nums,i,j);
            }
        }
        swap(nums,high,i+1);
        return i+1 ;

    }
    public void quickSort(int [] nums,int low,int high)
    {
        if(low<high)
        {
        int p = partition(nums,low,high) ;
        quickSort(nums,low,p-1) ;
        quickSort(nums,p+1,high) ;
        }
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums ;
    }
}