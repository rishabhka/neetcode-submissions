class Solution {
    //2,4,3
    //3,2
    //2
    // 2,5,1,4
    public int maxTurbulenceSize(int[] arr) {
        int len = 1 ; int n = arr.length;
        for(int k=0;k<n-1;k++)
        {
            if(arr[k]<arr[k+1]&&k%2==0||arr[k]>arr[k+1]&&k%2!=0)
            {
                int start = k; 
                while(k<n-1&&(arr[k]<arr[k+1]&&k%2==0||arr[k]>arr[k+1]&&k%2!=0))
                {
                    if(k+1-start+1>len)
                    len = k+1-start+1;
                    k++;
                }
                if(k>start)
            k--;
            }
            else
            {
                int start = k;
                while(k<n-1&&(arr[k]>arr[k+1]&&k%2==0||arr[k]<arr[k+1]&&k%2!=0))
                {
                    if(k+1-start+1>len)
                    len = k+1-start+1;
                    k++;
                }
                if(k>start)
                k--;
            }
        }
        return len ;
    }
}