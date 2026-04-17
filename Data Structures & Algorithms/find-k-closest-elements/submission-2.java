class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length ;
        int p= n-1 , q =n-1 ; int i =0;
        List<Integer> result = new ArrayList<>();
        while(i<arr.length)
        {
            if(arr[i]>x)
            {
                p = i-1;
                q= i ;
                break;
            }
            i++;
        }
        System.out.println(p+" "+q);
        while(k!=0)
        {
            if(p==q)
            p--;
            if(p>=0&&q<n) // check dist from both
            {
                int dist1 = Math.abs(x-arr[p]);
                int dist2 = Math.abs(x-arr[q]);
                System.out.println(dist1+" "+dist2);
                if(dist1<dist2||dist1==dist2)
                {
                    result.add(arr[p]);
                    p--;
                }
                else 
                {
                    result.add(arr[q]);
                    q++;
                }
            }
            else if(p>=0)
            {
                result.add(arr[p]);
                p -- ;
            }
            else
            {
                result.add(arr[q]);
                q ++ ;

            }
            k--;
        }
        Collections.sort(result);
        return result ;
    }
}