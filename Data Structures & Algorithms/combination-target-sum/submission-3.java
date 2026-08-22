class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, 0, target, subset, result);
        return result;
    }

    private void dfs(int[] nums, int i, int sum, int target, List<Integer> subset, List<List<Integer>> result) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(subset));
            return;
        }

        while (i < nums.length) {
            subset.add(nums[i]);
            dfs(nums, i, sum + nums[i], target, subset, result);
            subset.remove(subset.size() - 1);
            i++;
        }

    }
}
