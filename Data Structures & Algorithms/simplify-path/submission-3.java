class Solution {
    public String simplifyPath(String path) {
        String p =path.replaceAll("/+","/") ;
        String[] list = p.split("/") ;
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<list.length;i++)
        {
            if(list[i].equals(".."))
            {
            if(!stack.isEmpty())    
            stack.pop(); 
            else continue ;
            }
            else if(list[i].equals(".")||list[i].equals("")) continue ;
            else
            stack.push(list[i]) ;
        }
        String res = "/" ;
        for(int i=0;i<list.length;i++)
        System.out.println(list[i]);
        while(!stack.isEmpty())
        {
            if(stack.size()==1)
            {
            res = res + stack.removeLast(); break ;
            }
            res = res + stack.removeLast() + "/" ;
        }

        return res ;
    }
}