class Solution {


    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        int n = strs.length;
        HashMap<String , List<String> > map = new HashMap<>();

        for(String s : strs)
        {
            char [] chArray = s.toCharArray();
            Arrays.sort(chArray);
            String key = new String(chArray);
            if(map.containsKey(key))
            map.get(key).add(s);
            else
            map.put(key,new ArrayList<>(Arrays.asList(s)));
        }
        result.addAll(map.values());
        return result;
        
    }
}
