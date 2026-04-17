class Solution {
    public class Node 
    {
        int i;
        List<Node> list = new ArrayList<>(); 
        Node(int _i)
        {
           i = _i ;
        }
    }
    public boolean cycleDetect(Node node , int [] visited)
    {
        if(visited[node.i]==1)
        return true;
        if(visited[node.i]==2)
        return false;
       visited[node.i] = 1 ;
       for(int j=0;j<node.list.size();j++)
       {
        if(cycleDetect(node.list.get(j),visited))
        return true;
        
       }
       visited[node.i] =2 ;
       return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(numCourses==1)
        return true;
        int n = prerequisites.length;
        if(n<=0)
        return true;
        int m = prerequisites[0].length;
        

        HashMap<Integer,Node> map = new HashMap<>();
        for(int i=0;i<numCourses;i++)
        {
            Node node = new Node(i);
            map.put(i,node);
        }
        for(int i=0;i<n;i++)
        {

            if(prerequisites[i][0]==prerequisites[i][1])
            return false;
            Node source = map.get(prerequisites[i][0]);
            Node dest = map.get(prerequisites[i][1]);
            dest.list.add(source);
        }
        int [] visited = new int [numCourses] ;
        for(int i=0;i<numCourses;i++)
        {
            if(visited[i]==0&&cycleDetect(map.get(i),visited))
            return false;
        }
        return true;
    }
}