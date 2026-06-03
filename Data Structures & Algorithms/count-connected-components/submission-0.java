class Solution {
    private int[] parent;
    private int[] size;
    private int count;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge: edges) {
            int p = edge[0];
            int q = edge[1];
            union(p, q);
        }

        return count;

    }


    private int find(int p) {
        int root = p;
        while(root != parent[root]) root = parent[root];

        while (root != p) {
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
