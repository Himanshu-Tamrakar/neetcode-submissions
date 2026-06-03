class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        return permute(nums, 0);
    }

    private List<List<Integer>> permute(int[] nums, int i) {
        if (nums.length == i) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> res = permute(nums, i+1);

        List<List<Integer>> permutations = new ArrayList<>();
        int num = nums[i];
        for (List<Integer> per: res) {

            for (int j = 0; j <= per.size(); j++) {
                List<Integer> copy = new ArrayList<>(per);
                copy.add(j, num);
                permutations.add(copy);
            }

        }
        
        return permutations;
        
    }
}
