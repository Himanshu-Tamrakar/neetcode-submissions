class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        return permute(nums, 0, res);
    }

    private List<List<Integer>> permute(int[] nums, int i, List<List<Integer>> res) {
        if (nums.length == i) {
            return res;
        }

        int num = nums[i];
        
        List<List<Integer>> permutations = new ArrayList<>(); 

        for (List<Integer> per: res) {
            for (int j = 0; j <= per.size(); j++) {
                List<Integer> copy = new ArrayList<>(per);
                copy.add(j, num);
                permutations.add(copy);
            }
        }
        
        return permute(nums, i+1, permutations);
        
    }
}
