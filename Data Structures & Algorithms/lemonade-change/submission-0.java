class Solution {

    public boolean lemonadeChange(int[] bills) {
        int [] nums = new int [2] ;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5) nums[0] ++ ;
            else if(bills[i]==10)
            {
                if(nums[0]>0)
                {
                nums[0] -- ;
                nums[1] ++;
                }
                else return false;
            } 
            else
            {
                if(nums[0]>0&&nums[1]>0)
                {
                    nums[0]--;
                    nums[1]--;
                }
                else if(nums[1]==0&&nums[0]>2)
                nums[0] = nums[0] - 3;
                else return false;
            }
        }
        return true ;
    }
}