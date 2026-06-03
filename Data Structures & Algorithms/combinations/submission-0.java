class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();
        combine(n, k, 1, currSubset, res);
        return res;
    }

    private void combine(int n, int k, int i, List<Integer> currSubset, List<List<Integer>> res) {
        if (currSubset.size() == k) {
            res.add(new ArrayList<>(currSubset));
            return;
        } 
        if (i > n) {
            return;
        }

        currSubset.add(i);
        combine(n, k, i+1, currSubset, res);
        currSubset.remove(currSubset.size()-1);

        combine(n, k, i+1, currSubset, res);
    }


}