class Solution
{
	public String simplifyPath(String path)
	{
		path = path.replaceAll("/+","/") ;
		Stack<String> stack = new Stack<>();
		
		String [] str = path.split("/");
		
		for(int i=0;i<str.length;i++)
		{
		if(!stack.isEmpty()&&str[i].equals(".."))
		stack.pop();
        else if(stack.isEmpty()&&str[i].equals(".."))
		continue;
		else if(str[i].equals("."))
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
		String res = "/" ;
		for(int i=0;i<inter.length;i++)
		{
		res =  res + "/" + inter[i]  ;
		}
        res = res.replaceAll("/+","/") ;
		return  res ;
	}
}