class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> permutations = new ArrayList<>();

            for (List<Integer> permute: result) {
                for (int j = 0; j <= permute.size(); j++) {
                    List<Integer> copy = new ArrayList(permute);
                    copy.add(j, num);
                    permutations.add(copy);
                    if ((j) < permute.size() && (permute.get(j) == num)) break;
                }
            }
            result = permutations;
        }

        return result;
    }

}