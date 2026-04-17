class Solution {
    public int reverseBits(int n) {
        int result = 0;
        String s = ""; 
        while(n!=0)
        {
            int bit = n & 1 ;
            s = s + bit ;
            n = n >>> 1 ;
        }
        int p = 32-s.length() ;
        for(int i=0;i<p;i++)
        {
        s = s + '0';
        }
        System.out.println(s);
        int k=0;
        for(int j=s.length()-1;j>=0;j--)
        {
            if(s.charAt(j)=='1')
            {
            System.out.println(result);
            result += (1 << k);
            }
            k++;
        }
return result ;
    }
}
