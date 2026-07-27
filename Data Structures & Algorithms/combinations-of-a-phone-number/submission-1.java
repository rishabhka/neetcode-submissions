class Solution {
	public void dfs(String digits,int k,List<String> res) 
	{
	if(k==digits.length()) return ;
	List<String> temp1 = new ArrayList<>(res) ;
	List<String> temp2 = new ArrayList<>(map.get(digits.charAt(k)-'0')) ;
	res.clear();
	for(int i=0;i<temp1.size();i++)
	{
	 for(int j=0;j<temp2.size();j++)
	 {
		res.add(temp1.get(i)+temp2.get(j)) ;
	 }
	}
	 dfs(digits,k+1,res) ;
	}
	HashMap<Integer,List<String>> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
        if(digits.equals("")) return res ;
        res.add("");
        map.put(2,Arrays.asList("a","b","c")) ;
		map.put(3,Arrays.asList("d","e","f")) ;
		map.put(4,Arrays.asList("g","h","i")) ;
		map.put(5,Arrays.asList("j","k","l")) ;
		map.put(6,Arrays.asList("m","n","o")) ;
		map.put(7,Arrays.asList("p","q","r","s")) ;
		map.put(8,Arrays.asList("t","u","v")) ;
		map.put(9,Arrays.asList("w","x","y","z") );
		 dfs(digits,0,res) ;
		return res ;
    }
}