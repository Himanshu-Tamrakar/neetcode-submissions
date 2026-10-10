class UF {
    private int[] size;
    private int[] parent;
    private int count;

    public UF(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
    }

    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        int root = p;
        while (root != parent[root])
            root = parent[root];
        while (p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
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
    private UF uf;
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        uf = new UF(edges.length);

        for (int[] edge: edges) {
            int v = edge[0] - 1;
            int w = edge[1] - 1;
            if (uf.connected(v, w)) {
                res = edge;
            } else {
                uf.union(v, w);
            }
        }

        return res;
    }
}
