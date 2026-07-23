class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // BS - > first ele closeest to x
        List<Integer> res = new ArrayList<>();
        int i = 0 ; int j = arr.length-1;
        while(i<=j)
        {
          int mid = (i+j) >>> 1;
          if(arr[mid]>=x)
          j = mid -1  ;
          else i = mid + 1 ;
        }
        System.out.println(i+" "+j);
        j= i-1; 
        for(int l=0;l<k;l++)
        {
        if(i<arr.length&&j>=0){
            if(Math.abs(x-arr[i])>=Math.abs(x-arr[j]))
            {     res.add(arr[j--]);     }
            else  {
               res.add(arr[i++]);
            }
        }
        else if(i<arr.length)
        {
        res.add(arr[i]);
        i++ ;
        }
        else if(j>=0)
        {
        res.add(arr[j]);
        j--;
        }
        }
        Collections.sort(res);
        return res ;
    }
}