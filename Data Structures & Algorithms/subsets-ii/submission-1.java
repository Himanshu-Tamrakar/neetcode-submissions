class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        res.add(new ArrayList<>());

        int sz = 1;
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            sz = res.size();

            for (int j = 0; j < sz; j++) {
                List<Integer> subset = new ArrayList<>(res.get(j));
                subset.add(num);
                res.add(subset);
            }

            while (((i+1) < nums.length) && (nums[i+1] == nums[i])) {
                int sz1 = res.size();
                for (int j = sz; j < sz1; j++) {
                    List<Integer> subset = new ArrayList<>(res.get(j));
                    subset.add(num);
                    res.add(subset);
                }
                sz = sz1;
                i++;
            }
        }
        return res;
    }


}
