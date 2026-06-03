class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        subsetWithDup(nums, 0, new ArrayList(), res);
        return res;
    }

    private void subsetWithDup(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            res.add(new ArrayList(subset));
            return;
        }

        subset.add(nums[i]);
        subsetWithDup(nums, i+1, subset, res);
        
        while (i+1 < nums.length && nums[i] == nums[i+1]) i++;
        subset.remove(subset.size()-1);
        subsetWithDup(nums, i+1, subset, res);

    }
}
