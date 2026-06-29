class Solution {
    public boolean match(String s, String p, int i, int j) {
    if (j == p.length()) return i == s.length();

    boolean firstMatch = i < s.length() &&
        (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));

    if (j+1 < p.length() && p.charAt(j+1) == '*') {
        return match(s, p, i, j+2)                 // zero
            || (firstMatch && match(s, p, i+1, j)); // one+
    } else {
        return firstMatch && match(s, p, i+1, j+1);
    }
}
    public boolean isMatch(String s, String p) {
        return match(s,p,0,0);
    }
}
