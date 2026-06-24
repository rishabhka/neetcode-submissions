class Solution {
    String seprator = "&*%^";
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>() ;
        int i=0;
        while(i<str.length())
        {
            String charlen = "";
            while(str.charAt(i)!='#')
            {
            charlen = charlen + str.charAt(i);
            i++;
            }
            i++;
            int len = Integer.parseInt(charlen);
            char [] word= new char[len];
            for(int j=0;j<len;j++,i++)
            {
            word[j] = str.charAt(i);
            }
            String f = new String(word) ;
            result.add(f);
        }
        
        return result;
    }
}
