class Solution {
    int ptr =0 ;
    public class Node
    {
        int val ;
        List<Integer> list ;
        Node(int val)
        {
            this.val = val;
            list = new ArrayList<>();
        }
    }
    public boolean dfs (List<Node> adjList,int i,int [] visited,int [] result)
    {
        System.out.println(visited[i]);
        if(visited[i]==1)
        return true;
        if(visited[i]==2)
        return false;
        visited[i] = 1;
        for(int j=0;j<adjList.get(i).list.size();j++)
        {
            if(dfs(adjList,adjList.get(i).list.get(j),visited,result))
            return true;
        }
        visited[i] = 2;
        result[ptr] = i;
        ptr ++;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Node> adjList = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            Node node = new Node(i);
            adjList.add(node);
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            adjList.get(x).list.add(y);
        }
        int visited [] = new int [numCourses];
        int result [] = new int [numCourses] ;
        for(int i=0;i<numCourses;i++)
        {
            // System.out.println(dfs(adjList,i,visited,result));
            if(dfs(adjList,i,visited,result))  
            return new int[0];    
        }
        return result ;

    }
}
