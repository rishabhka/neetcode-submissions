class Solution {
    public class Node
    {
        int i ;
        List<Integer> adjList ;
        Node(int i)
        {
            this.i = i;
            adjList = new ArrayList<>();
        }
    }
    public boolean ifCycle(List<Node> result,int numCourses,int [] visited,int i)
    {
        System.out.println(i);
        if(visited[i]==1)
        return true ;
        visited[i] = 1;
        for(int j=0;j<result.get(i).adjList.size();j++)
        {
            int neigbour = result.get(i).adjList.get(j);
            if( ifCycle(result,numCourses,visited,neigbour))
            return true;
        }
        visited[i] = 2;
        return false;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // List<Node> list = new ArrayList<>();

        if(prerequisites.length==0||numCourses==1)
        return true ;

        List<Node> result = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            Node node = new Node (i);
            result.add(node);
        }
        System.out.println(result.size());
        for(int i=0;i<prerequisites.length;i++)
        { 
            Node node = result.get(prerequisites[i][1]);
            node.adjList.add(prerequisites[i][0]);
        }
        
        
        for(int i=0;i<result.size();i++)
        {
            int visited [] = new int [numCourses] ;
            Node vertex = result.get(i);
            // visited[i] = 1;

            if(ifCycle(result,numCourses,visited,i))
            return false;

        }
       return true ;
        
    }
}