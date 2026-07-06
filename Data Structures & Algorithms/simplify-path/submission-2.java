class Solution
{
	public String simplifyPath(String path)
	{
		path = path.replaceAll("/+","/") ;
		Stack<String> stack = new Stack<>();
		
		String [] str = path.split("/");
		
		for(int i=0;i<str.length;i++)
		{
		if(str[i].equals(".."))
        {
        if(!stack.isEmpty())    
		stack.pop();
        }
		else if(str[i].equals("") ||str[i].equals("."))
		continue ;
		else
		stack.push(str[i]);
		}
		// stack -> nc , prac , course
		String [] inter = new String [stack.size()] ;
		for(int i=inter.length-1;i>=0;i--)
		{
		inter[i] = stack.pop();
 		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<inter.length;i++)
		{
		sb.append("/").append(inter[i]);
		}
        
		return  sb.toString().equals("")?"/":sb.toString() ;
	}
}