class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        if(nums.length==0)
        return result ;
        int maj1 = 0 ; int count1=0 ;
        int maj2 =0  ; int count2=0 ; 

        for(int el : nums)
        {
            if(maj1==el)
            count1++ ;
            else if(maj2==el)
            count2++;
            else if(count1==0)
            {
                maj1= el;
                count1 =1;
            }
            else if(count2==0)
            {
                maj2 = el ;
                count2 =1 ;
            }
            else
            {
                count1 --;
                count2 --;
            }
        } 
        count1 =0 ;
        count2 =0 ;
        for(int el : nums)
        {
            if(el==maj1)
            count1 ++;
            if(el==maj2)
            count2 ++;
        }
        if(count1>Math.floor(nums.length/3))
        result.add(maj1);

        if(count2>Math.floor(nums.length/3))
        result.add(maj2);
        
        return result ;

    }
}