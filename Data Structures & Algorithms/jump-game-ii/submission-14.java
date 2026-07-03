class Solution {
    public int jump(int[] nums) {
        int n = nums.length ;
        if(n==0) return 0 ;
        if(n==1) return 0;
        int p=0; int q=0; int jump =0;
        int max = nums[p]+p; 
        while(q<n)
        {
            int range = max;
            while(q<=range&&q<n)
            {
                if(nums[q]+q>max) max = nums[q]+q;
                q++;
            }
            if(q>n) break;
            p= q;
            jump++;

        }
        return jump;
    }
}
