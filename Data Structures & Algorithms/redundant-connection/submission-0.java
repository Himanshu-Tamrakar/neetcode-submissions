class Solution {
    private int[] parent;
    private int[] size;
    private int count;
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        parent = new int[100];
        size = new int[100];
        count = 100;

        for (int i = 0; i < 100; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge: edges) {
            int p = edge[0];
            int q = edge[1];
            p--;
            q--;
            if (!union(p, q)) {
                res[0] = p+1;
                res[1] = q+1;
            }
        }

        return res;
    }

    private int find(int p) {
        int root = p;
        while (root != parent[root]) root = parent[root];

        while (p != root) {
            int newP = parent[p];
            parent[p] = root;
            p = newP;
        }
        return root;
    }

    private boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return false;

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
        return true;
    }
}
