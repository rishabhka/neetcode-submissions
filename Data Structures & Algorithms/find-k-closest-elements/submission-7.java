class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int i = 0 ; int j = arr.length-1;
        while(i<=j)
        {
          int mid = (i+j) >>> 1;
          if(arr[mid]>=x)
          j = mid -1  ;
          else i = mid + 1 ;
        } int temp = i ;
        i = Math.min(i,j) ; j = Math.max(temp,j); int n = arr.length ;
        for(int l=0;l<k;l++)
        {
            if(j<n&&i>=0)
            {
                if(Math.abs(arr[j]-x)-Math.abs(arr[i]-x)>=0)
                i -- ;
                else j++;
            }
            else if(j<n)
            j++;
            else
            i--;
        }
        System.out.println(i+ " "+ j);
        for(int l=0;l<k;l++)
        {
        res.add(arr[i+1]); i++;
        }
        return res ;
    }
}