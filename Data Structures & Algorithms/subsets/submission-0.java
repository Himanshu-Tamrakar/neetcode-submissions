class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        subsets(nums, 0, new ArrayList(), res);
        return res;
    }

    private void subsets(int[] nums, int i, List<Integer> currSet, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList(currSet));
            return;
        }
        currSet.add(nums[i]);
        subsets(nums, i+1, currSet, res);

        currSet.remove(currSet.size()-1);
        subsets(nums, i+1, currSet, res);
    }
}
