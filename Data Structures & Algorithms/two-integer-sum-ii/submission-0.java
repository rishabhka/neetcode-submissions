class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] result = new int [2] ;

        int p=0;
        int q = numbers.length-1;
        while(p<q)
        {
            if(numbers[p]+numbers[q]==target)
            {
                result [0] = p+1;
                result [1] = q+1;
                return result; 
            }
            else if(numbers[p]+numbers[q]<target)
            {
                p++;
            }
            else
            q--;
        }
        return result;
    }
}
