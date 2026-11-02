class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, Integer> cache = new HashMap<>();
        return helper(0, strs,m, n, cache);
    }

    private int helper(int i, String[] strs, int m, int n, Map<String, Integer> cache) {
        if (i == strs.length) {
            return 0;
        }

        String key = i + "-" + m + "-" + n;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int skip = helper(i + 1, strs, m, n, cache);

        int include = 0;
        int zero = count(strs[i], 0);
        int one = count(strs[i], 1);
        if (zero <= m && one <= n) {
            include = 1 + helper(i + 1, strs, m - zero, n - one, cache);
        }
        cache.put(key, Math.max(include, skip));

        return cache.get(key);
    }

    private int count(String s, int c) {
        int cnt = 0;
        if (c == 1) {
            for (char ch: s.toCharArray()) {
                if (ch == '1') cnt++;
            }
        } else {
            for (char ch: s.toCharArray()) {
                if (ch == '0') cnt++;
            }
        }
        return cnt;

    }
}