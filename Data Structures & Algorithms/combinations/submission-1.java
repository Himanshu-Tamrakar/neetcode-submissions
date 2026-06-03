class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currSubset = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            currSubset.add(i);
            combine(n, k, i, currSubset, res);
            currSubset.remove(currSubset.size()-1);
        }
        
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

        
        for (int j = i+1; j <= n; j++) {
            currSubset.add(j);
            combine(n, k, j, currSubset, res);
            currSubset.remove(currSubset.size()-1);
        }
    }


}