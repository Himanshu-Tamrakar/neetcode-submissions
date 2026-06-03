class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        combinationSum(nums, target, 0, curr, 0, res);
        return res;        
    }

    private void combinationSum(int[] nums, int target, int i, List<Integer> curr, int total, List<List<Integer>> res) {
        if (total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i == nums.length || total > target) {
            return;
        }

        curr.add(nums[i]);
        combinationSum(nums, target, i, curr, total + nums[i], res);
        curr.remove(curr.size()-1);
        combinationSum(nums, target, i+1, curr, total, res);
    }
}