class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int res = 1;
        Set<Integer> st = new HashSet<>();
        for (int num: nums) st.add(num);

        for (int num: nums) {
            if (!st.contains(num-1)) {
                int cnt = 1;

                while (st.contains(num+1)) {
                    cnt++;
                    num = num+1;
                }

                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
