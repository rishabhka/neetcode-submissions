class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // int [] result = new int [2] ;
        int p=0; int q = numbers.length-1;
        while(p<q)
        {
            if(numbers[p]+numbers[q]==target)
            {
                return new int [] {p+1,q+1};
            }
            else if(numbers[p]+numbers[q]>target)
            q--;
            else
            p++;

        }
        return new int []{};
    }
}
