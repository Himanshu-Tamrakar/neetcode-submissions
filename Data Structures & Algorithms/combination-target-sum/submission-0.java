class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int total = nums[i];
            curr.add(nums[i]);
            combinationSum(nums, target, i, curr, total, res);
            curr.remove(curr.size()-1);
        }
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

        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            total += nums[j];
            combinationSum(nums, target, j, curr, total, res);
            total -= nums[j];
            curr.remove(curr.size()-1);
        }
    }
}