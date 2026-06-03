class Solution {
    Set<String> st = new HashSet<>();
    public Solution() {

        for (int i = 0; i < 26; i++) {
            st.add(String.valueOf(i + 1));
        }
    }
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0, memo);
    }

    private int dfs(String s, int i, int[] memo) {
        if (i == s.length()) return 1;

        if (s.charAt(i) == '0') return 0;
        if (memo[i] != -1) return memo[i];
        int res = dfs(s, i + 1, memo);
        if (i + 1 < s.length()) {
            String takeTwoChar = s.substring(i, i + 2);
            if (st.contains(takeTwoChar)) {
                res += dfs(s, i + 2, memo);
            }

        }
        
      
        return res;
    }
}
