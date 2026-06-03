class Solution {
     public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum % 2) != 0) return false;
        int target = sum / 2;

        Set<Integer> st = new HashSet<>();
        st.add(0);

        for (int i = nums.length-1; i >= 0; i--) {
            Set<Integer> newST = new HashSet<>();
            for (int val: st) {
                if (val + nums[i] == target) {
                    return true;
                }
                newST.add(val);
                newST.add(val + nums[i]);
            }
            st = newST;
        }

        return false;
    }

    private boolean dfs(int i, int[] nums, int cap) {
        if (i == nums.length) return false;

        boolean maxProfit = dfs(i + 1, nums, cap);

        int newCap = cap - nums[i];
        if (newCap == 0) return true;
        if (newCap >= 0) {
            maxProfit = maxProfit || dfs(i + 1, nums, newCap);;
        }
        return maxProfit;
    }

   
}
