class Solution {
    public String decodeString(String s) {
        String res = "" ; int n = s.length(); int digit = 0;
        Deque<String> stack = new ArrayDeque<>(); 
        for(int i=0;i<n;i++ )
        {
            if(Character.isDigit(s.charAt(i)))
            digit = digit * 10 + Integer.parseInt(s.charAt(i)+"") ;
            else if(s.charAt(i)==']')
            {
                String str = "";
                while(!stack.peek().equals("["))
                str= stack.poll()+ str  ;
                stack.poll();
                int num = Integer.parseInt(stack.poll()); String inter = "";
                for(int j=0;j<num;j++)
                inter= inter + str ;
                StringBuilder sb = new StringBuilder(inter);
                stack.push(inter);
            }
            else 
            {
            if(digit!=0)
            stack.push(digit+"") ;
            digit =0;    
            stack.push(s.charAt(i)+"");
            }
            
        }
        while(!stack.isEmpty())
        {
            res = res + stack.removeLast();
        }
        return res ;
    }
}