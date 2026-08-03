class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList<>();
        if (s.charAt(s.length()-1) =='1')
            return false;
        q.offer(0);
        int last = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            for (int j = Math.max(i + minJump, last); j <= (i + maxJump) && (j < s.length()); j++) {
                if (j == s.length() - 1)
                    return true;
                if (s.charAt(j) =='0')
                    q.offer(j);
                    last = i + maxJump ;
            }
        }
        return false;
    }
}