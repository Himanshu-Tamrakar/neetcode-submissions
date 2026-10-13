class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        dfs(1, n, k, currList, res);
        return res;
    }

    private void dfs(int i, int n, int k, List<Integer> currList, List<List<Integer>> res) {
        if (k == currList.size()) {
            res.add(new ArrayList<>(currList));
            return;
        }
        if (i > n) {
            return;
        }

        currList.add(i);
        dfs(i + 1,  n, k, currList, res);
        currList.remove(currList.size() - 1);
        dfs(i + 1, n, k, currList, res);
    }
}