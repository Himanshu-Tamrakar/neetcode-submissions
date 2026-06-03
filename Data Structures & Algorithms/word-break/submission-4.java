class Solution {
    private Map<Integer, Boolean> memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>();
        memo.put(s.length(), true);
        return dfs(s, wordDict, 0, memo);
    }

    private boolean dfs(String s, List<String> wordDict, int i, Map<Integer, Boolean> memo) {
        if (memo.containsKey(i)) return memo.get(i);

        boolean res = false;
        for (String str: wordDict) {
            String sub = s.substring(i, Math.min(s.length(), i + str.length()));
            if (sub.equals(str)) {
                res = res || dfs(s, wordDict, i + str.length(), memo);
            }
        }
        memo.put(i, res);
        return memo.get(i);
    }
}
