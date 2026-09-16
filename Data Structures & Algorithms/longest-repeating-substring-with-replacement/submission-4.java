class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int L = 0;
        int res = 0;

        for (int R = 0; R < s.length(); R++) {
            count[s.charAt(R) - 'A']++;
            
            // get max freq from count
            int max  = -1;
            for (int entry: count) {
                if (max < entry) {
                    max = entry;
                }
            }

            while ((R - L + 1) - max > k) {
                count[s.charAt(L) - 'A']--;
                L++;
            }

            res = Math.max(res, R - L + 1);
        }

        return res;
    }
}
