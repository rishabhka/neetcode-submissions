class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int i = s.length()-1;
        if(s.charAt(i)=='1') return false;
        while(i>0)
        {
            // i = i - minJump;
            int last = -1 ;
            int r = i - minJump;
            int l = i - maxJump ;
            while(r>=l&&r>=0)
            {
                if(r==0) return true ;
                if(s.charAt(r)=='0')
                last = r ;
                r--;
            }
            if(last==-1) return false;
            i = last ;
        }
        return true ;
    }
}