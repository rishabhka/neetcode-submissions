class Solution {
    public int f(int n)
    {
        if(n==2||n==3)
        return n;
        else if(n==4)
        return f(n-2)*2 ;
        else return f(n-3)*3 ;
    }
    public int integerBreak(int n) {
        if(n==2)
        return 1;
        else if(n==3)
        return 2;
        return f(n);
    }
}