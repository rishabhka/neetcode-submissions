class Solution {
    // public int binarySearch(int [] arr,int i,int j, int target)
    // {
    //     if(i>j) return i ;
    //     else
    //     {
    //         int mid = (i+j) >> 1 ;
    //         if(mid==target) return mid ;
    //         else if(mid>target)
    //         j = mid  ;
    //         else i = mid;
    //     }
    // return i;
    // }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // BS - > first ele closeest to x
        List<Integer> res = new ArrayList<>();
        int i = 0 ; int j = arr.length-1;
        while(i<j)
        {
            if(i>j) break ;
            else if(i==j-1)
            {
            i= Math.abs(x-arr[i])-Math.abs(x-arr[j])>0?j:i ;
            break ;
            }
            else
            {
                int mid = (i+j) >> 1;
                if(arr[mid]==x) {i= mid ; break; }
                else if(x<arr[mid]) j = mid ;
                else i = mid ;
            }
        }
        j= i-1; 
        for(int l=0;l<k;l++)
        {
        if(i<arr.length&&j>=0){
            if(Math.abs(x-arr[i])>=Math.abs(x-arr[j]))
            {
                res.add(arr[j]);
                j--;
            }
            else
            {
               res.add(arr[i]);
               i++ ;
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