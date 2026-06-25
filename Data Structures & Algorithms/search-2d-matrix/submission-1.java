class Solution {
    public boolean binarySearch(int [][] matrix ,int i , int j ,  int m , int n, int target)
    {
        if(i>j)
        return false;
        int mid = (i+j)/2;
        int row = mid/n;
        int col = mid % n; 
        if(matrix[row][col]==target)
        return true ;
        else if(matrix[row][col]>target)
        return binarySearch(matrix,i ,row*n+col-1 ,m ,n,target);
        else
        return binarySearch(matrix,row*n+col+1 ,j ,m ,n,target);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length ; int n = matrix[0].length;
        int i = 0; int j = n*m-1;
        return binarySearch(matrix,i ,j ,m ,n,target);
    }
}
