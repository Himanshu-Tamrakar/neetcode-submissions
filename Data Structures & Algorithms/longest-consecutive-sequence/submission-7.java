class UF {
    private int[] parent;
    private int[] size;
    private int count;

    public UF(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    } 

    public int find(int p) {
        int root = p;
        while (parent[root] != root) {
            root = parent[root];
        }

        while (p != parent[p]) {
            int newP = parent[p];
            parent[p] = root;
            p = newP;
        }

        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        UF uf = new UF(n);
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToIdx.put(nums[i], i);
        }

        // union the indexes
        for (int i = 0; i < nums.length; i++) {
            if (numToIdx.containsKey(nums[i] + 1)) {
                uf.union(i, numToIdx.get(nums[i] + 1));
            }
        }

        // group it without duplicate value as we union with last duplicate one
        // [1,2,3,4,5,1]
        // un numToIdx 1 : 5 not 0
        int[] count = new int[n];
        for (int i: numToIdx.values()) {
            count[uf.find(i)]++;
        }

        int res = 0;
        for (int cnt: count) {
            res = Math.max(res, cnt);
        }

        return res;
    }
}
