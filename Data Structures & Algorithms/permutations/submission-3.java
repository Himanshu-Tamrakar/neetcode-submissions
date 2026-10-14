class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        dfs(nums, new boolean[nums.length], currList, res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visit, List<Integer> currList,List<List<Integer>> res) {
        if (currList.size() == nums.length) {
            res.add(new ArrayList<>(currList));
            return;
        }
        
        for (int j = 0; j < nums.length; j++) {
            if (visit[j]) continue;
            visit[j] = true;
            currList.add(nums[j]);
            dfs(nums, visit, currList, res);
            currList.remove(currList.size() - 1);
            visit[j] = false;
        }   
    }
}
