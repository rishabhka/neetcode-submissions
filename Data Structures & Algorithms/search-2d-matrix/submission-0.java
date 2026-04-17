class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        if(m==0||n==0)
        return false;
        else
        {
            int i = 0;
            int j = n*m-1;
            while(i<=j)
            {
                System.out.println(i+ " "+ j);
                int mid = (j-i)/2 + i ;
                int mid_i = mid / m ;
                int mid_j = mid % m ;
                if(target==matrix[mid_i][mid_j])
                return true;
                else if(target>matrix[mid_i][mid_j])
                i = mid + 1;
                else
                j = mid -1 ; 

            }
            return false;
        }
        
    }
}
