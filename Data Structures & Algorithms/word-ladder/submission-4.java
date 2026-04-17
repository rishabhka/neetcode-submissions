class Solution {
    int best = Integer.MAX_VALUE;

    public boolean findDiff(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }

    public void dfs(String curr, String endWord, List<String> wordList, int len) {
        if (len >= best) return;

        if (curr.equals(endWord)) {
            best = Math.min(best, len);
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (findDiff(curr, word)) {
                List<String> newList = new ArrayList<>(wordList);
                newList.remove(i);
                dfs(word, endWord, newList, len + 1);
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        dfs(beginWord, endWord, wordList, 1);
        return best == Integer.MAX_VALUE ? 0 : best;
    }
}
