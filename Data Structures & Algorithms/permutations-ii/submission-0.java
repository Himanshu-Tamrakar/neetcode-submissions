class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        return permuteUnique(nums, 0);
    }

    private List<List<Integer>> permuteUnique(int[] nums, int i) {
        if (nums.length == i) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> res = permuteUnique(nums, i+1);

        int num = nums[i];
        List<List<Integer>> permutations = new ArrayList<>();
        for (List<Integer> permute: res) {
            
            for (int j = 0; j <= permute.size(); j++) {
                List<Integer> copy = new ArrayList(permute);
                copy.add(j, num);
                permutations.add(copy);

                if ((j) < permute.size() && (permute.get(j) == num)) break;
            }
        }

        return permutations;
    }
}