class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length ;
        Arrays.sort(people);
        if(people[n-1]>limit)
        return -1 ;
        else
        {
            int k = 0; int count =0 ;
            int i=0; int j = n-1 ;
            while(i<=j)
            {
                if(i==j)
                {
                count ++ ;
                i++; j --;
                }
                else if(people[i]+people[j]<=limit)
                {
                    count ++;
                    i++; j --;
                }
                else 
                {
                    count ++;
                    j -- ;
                }


            }
            return count ;          
        }

    }
}