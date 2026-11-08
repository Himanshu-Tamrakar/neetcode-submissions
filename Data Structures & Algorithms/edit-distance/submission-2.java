class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int N = word1.length();
        int M = word2.length();
        int[][] cache = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(cache[i], -1);
        }

        return dfs(word1, word2, 0, 0, cache);
        
    }

    private int dfs(String s, String t, int i, int j, int[][] cache) {

        if (i == s.length()) return t.length() - j;
        if (j == t.length()) return s.length() - i;

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (i < s.length() && j < t.length() && (s.charAt(i) == t.charAt(j))) {
            cache[i][j] = dfs(s, t, i + 1, j + 1, cache);
        } else {
            int a = dfs(s, t, i, j + 1, cache); // insert
            int b = dfs(s, t, i + 1, j + 1, cache); // update
            int c = dfs(s, t, i + 1, j, cache); // delete
            cache[i][j] = 1 + Math.min(c, Math.min(a, b));
        }

        return cache[i][j];
    }
}
