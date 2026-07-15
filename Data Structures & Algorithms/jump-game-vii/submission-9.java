class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();
q.add(0);
int maxReached = 0;
while (!q.isEmpty()) {
    int i = q.poll();
    for (int j = Math.max(i + minJump, maxReached + 1); j <= Math.min(i + maxJump, n - 1); j++) {
        if (s.charAt(j) == '0') {
            if (j == n - 1) return true;
            q.add(j);
        }
        maxReached = j;
    }
}
return false;
    }
}