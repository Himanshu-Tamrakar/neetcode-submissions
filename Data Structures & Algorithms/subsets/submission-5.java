class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        dfs(nums, 0, currList, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> currList, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }

        currList.add(nums[i]);
        dfs(nums, i + 1, currList, res);

        currList.remove(currList.size() -1);
        dfs(nums, i + 1, currList, res);
    }

    // Iterative
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList());

        // Iterative
        for (int i = 0; i < nums.length; i++) {
            int sz = res.size();
            for (int j = 0; j < sz; j++) {
                List<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(new ArrayList<>(temp));
            }
        }

        return res;
    }
}
