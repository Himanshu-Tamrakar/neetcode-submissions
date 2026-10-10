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
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge: edges) {
            int v = edge[0];
            int w = edge[1];
            uf.union(v, w);
        }

        return uf.count;
    }
}
