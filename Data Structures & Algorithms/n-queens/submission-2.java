class Solution {
    public boolean check(int r,int c,char [][] visited)
    {
        for(int i=r-1;i>=0;i--)
        if(visited[i][c]=='Q') return false;
        for(int i=r-1, j=c-1;i>=0&&j>=0;i--,j--)
        if(visited[i][j]=='Q') return false;
        for(int i=r-1,j=c+1;i>=0&&j<visited.length;i--,j++)
        if(visited[i][j]=='Q') return false;
        return true ;

    }
    public void dfs(int i,char [][] visited,List<List<String>> res )
    {
        if(i==visited.length)
        {
            List<String> temp = new ArrayList<>();
            for(int k=0;k<visited.length;k++){
            String val = "" ;
            for(int j=0;j<visited.length;j++)
            {
            val = val+ visited[k][j] ;
            }
            temp.add(val);
            }
            res.add(temp);
        return ;
        }
        for(int j=0;j<visited.length;j++){
            if(check(i,j,visited))
            {
            visited[i][j] = 'Q' ;
            dfs(i+1,visited,res);
            }
            visited[i][j]= '.';
        }
        return ;

    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char [][] visited = new char [n][n] ;
        for(int i=0;i<visited.length;i++)
        Arrays.fill(visited[i],'.') ;
        dfs(0,visited,res);
        return res;
    }
}
