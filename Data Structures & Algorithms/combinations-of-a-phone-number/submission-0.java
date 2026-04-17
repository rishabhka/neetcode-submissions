class Solution {
    public List<String> crossMul(List<String> temp1,List<String> temp2)
    {
        List<String> result = new ArrayList<>();
        for(int i=0;i<temp1.size();i++)
        {
            for(int j=0;j<temp2.size();j++)
        {
            String val1 = temp1.get(i);
            String val2 = temp2.get(j);
            result.add(val1+val2);
        }
        }
        return result ;

    }
    public List<String> letterCombinations(String digits) {
        
        HashMap<Integer, List<String> > map = new HashMap<>();
        map.put(2,Arrays.asList("a", "b", "c")) ;
        map.put(3,Arrays.asList("d", "e", "f")) ;
        map.put(4,Arrays.asList("g", "h", "i")) ;
        map.put(5,Arrays.asList("j", "k", "l")) ;
        map.put(6,Arrays.asList("m", "n", "o")) ;
        map.put(7,Arrays.asList("p", "q", "r","s")) ;
        map.put(8,Arrays.asList("t", "u", "v")) ;
        map.put(9,Arrays.asList("w", "x", "y","z")) ;
        if(digits.length()==0) return new ArrayList<>();
        List<String> temp = map.get(digits.charAt(0)-'0');
        for(int i =1;i<digits.length();i++)
        {
            List<String> now = map.get(digits.charAt(i)-'0');
            temp = crossMul(temp,now);
        }
        return temp ;
    }
}
