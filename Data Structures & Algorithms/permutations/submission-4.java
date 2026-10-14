public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }

        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> p : perms) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(i, nums[0]);
                res.add(p_copy);
            }
        }
        return res;
    }
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

