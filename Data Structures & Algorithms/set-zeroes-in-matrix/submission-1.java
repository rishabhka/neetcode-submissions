class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int [] row = new int [m];
        Arrays.fill(row,-1);
        int [] col = new int [n];
        Arrays.fill(col,-1);
        for(int i=0;i<m;i++)
        {
        int product = 1;
        for(int j=0;j<n;j++)
        {
            product = product * matrix[i][j];
            if(matrix[i][j]==0)
            col[j]=0;
        }
        if(product==0)
       row[i] = product ;
        }
        for(int i=0;i<m;i++)
        {
            if(row[i]==0)
            {
                for(int j=0;j<n;j++)
                {
                    matrix[i][j]=0;
                }

            }
        }
        for(int i=0;i<n;i++)
        {
            if(col[i]==0)
            {
                for(int j=0;j<m;j++)
                {
                    matrix[j][i]=0;
                }

            }
        }
        
    }
}
