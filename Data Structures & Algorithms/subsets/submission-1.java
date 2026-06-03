class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());

        for(int num: nums) {
            int sz = res.size();
            for (int i = 0; i < sz; i++) {
                List<Integer> subset = new ArrayList(res.get(i));
                subset.add(num);
                res.add(subset);
            }
        }
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
