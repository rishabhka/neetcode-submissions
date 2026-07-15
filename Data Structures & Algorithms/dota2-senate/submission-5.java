class Solution {
    public String predictPartyVictory(String s) {
        int p =0 ;int q=0 ; int r =0 ;
        int [] nums = new int [s.length()] ;
        for(int i=0;i<nums.length;i++)
        nums[i] = 1;
        while(q<s.length())
        {
            if(s.charAt(p)==s.charAt(q))
            {
                if(s.charAt(r)!=s.charAt(q))
                {
                    nums[r] = -1;
                    r++;
                }
            }
            else
            {
                if(nums[p]==1)
                {
                    nums[q] = -1;
                    p++;
                }
            }
            q++;
        } int count =0; boolean flag = true ; char first='a' ;
        for(int i=r;i<s.length();i++)
        {   
        if(s.charAt(i)=='D'&&nums[i]==1) 
        {count ++;
        if(flag)
        {
            flag = false ;
            first = s.charAt(i);
        }
        }
        else if(s.charAt(i)=='R'&&nums[i]==1)
        {count -- ;
        if(flag)
        {
            flag = false ;
            first = s.charAt(i);
        }
        }
        }
        // System.out.println(count);
        if(count==0){
            return first=='D'?"Dire":"Radiant" ;
        }
        return count>0?"Dire":"Radiant" ;
    }
}