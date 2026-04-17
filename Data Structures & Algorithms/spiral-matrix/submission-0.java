class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int left = 0 ;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length ;
        while(top<bottom&&left<right)
        {
            System.out.println(left + " "+right+ " "+top+ " "+bottom);
            for(int i=left;i<right;i++)
            {
                list.add(matrix[top][i]);
            }
            top ++ ;
            for(int i=top;i<bottom;i++)
            {
                list.add(matrix[i][right-1]);
            }
            right -- ;
            if(top<bottom&&left<right)
            {
            for(int i=right-1;left<=i;i--)
            {
                list.add(matrix[bottom-1][i]);
            }
            bottom -- ;
            }
            if(top<bottom&&left<right)
            {
            for(int i=bottom-1;top<=i;i--)
            {
                list.add(matrix[i][left]);
            }
            left ++ ;
            }
        }
        return list ;
    }
}
