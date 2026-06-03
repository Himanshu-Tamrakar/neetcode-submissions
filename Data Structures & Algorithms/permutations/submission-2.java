class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> permutations = new ArrayList<>();

            for (List<Integer> per: res) {

                for (int j = 0; j <= per.size(); j++) {
                    List<Integer> copy = new ArrayList<>(per);
                    copy.add(j, num);
                    permutations.add(copy);
                }

            }

            res = permutations;    
        }

        return res;

    }


}
