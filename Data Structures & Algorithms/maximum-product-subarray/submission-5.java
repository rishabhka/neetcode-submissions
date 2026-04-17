class Solution {

    int max_product = Integer.MIN_VALUE ;

    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n==0)
        return 0;
        else if (n==1)
        return nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i=1;i<n;i++)
        {
           int x = nums[i] ;
           int y = nums[i] * max ;
           int z = nums[i] * min ;
           min = Math.min(x,Math.min(y,z));
           max = Math.max(x,Math.max(y,z));
           if(max>max_product)
           max_product = max;
        }
        return max_product;
    }
}
