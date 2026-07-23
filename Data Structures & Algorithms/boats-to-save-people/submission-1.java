class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people) ;
        int p = 0; int q = people.length-1; int cnt =0;
        while(p<=q)
        {
            if(people[p]+people[q]<=limit)
            {
            cnt ++ ; p++; q--;
            }
            else{
                q-- ;
                cnt ++ ;
            }
        }
        return cnt ;
    }
}