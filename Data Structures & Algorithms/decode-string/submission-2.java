class Solution
{
	public String decodeString(String s)
	{
	Deque<String> stack = new ArrayDeque<>();
	int num =0;
	for(char ch : s.toCharArray())
	{
	if(ch==']')
	{
	String  temp = "";
	while(!stack.peek().equals("["))
	{
	temp = stack.pop() + temp ;
	}
	stack.pop();
	String times = "" ;
    while(!stack.isEmpty()&&Character.isDigit(stack.peek().charAt(0)))
    {
        times = stack.pop()+times ;
    }
	String res = "" ;
	for(int i=0;i<Integer.parseInt(times);i++)
	res= res + temp ;
	stack.push(res);
    System.out.println(res);
	}	
	else 
	stack.push(String.valueOf(ch)) ;	
	}
    String result = "" ;
    Iterator<String> it = stack.descendingIterator();
    while(it.hasNext())
    result = result + it.next();
    return result ;
	}
}