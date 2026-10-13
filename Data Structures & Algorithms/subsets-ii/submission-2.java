class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
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

        currList.remove(currList.size() - 1);

        while (i + 1 < nums.length && nums[i] == nums[i+1]) {
            i++;
        }

        dfs(nums, i + 1, currList, res);
    }
}
