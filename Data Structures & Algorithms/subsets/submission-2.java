class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for (int num: nums) {
            int sz = res.size();
            for (int i = 0; i < sz; i++) {
                List<Integer> separateList = new ArrayList<>(res.get(i));
                separateList.add(num);
                res.add(separateList);
            }
        }

        return res;
    }
}
