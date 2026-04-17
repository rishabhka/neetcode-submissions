class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int [] prefix = new int [n];
        int [] suffix = new int [n];
        prefix[0] = 1;
        suffix[n-1] =1 ;
        int sum =1;
        for(int i=1;i<n;i++)
        {
          sum = sum * nums [i-1] ;
          prefix[i] = sum ;
        }
        sum =1 ;
        for(int i=n-2;i>=0;i--)
        {
          sum = sum * nums [i+1] ;
          suffix[i] = sum ;
        }
        for(int i=0;i<n;i++)
        suffix[i] = suffix[i]*prefix[i];
        return suffix;
    }
}