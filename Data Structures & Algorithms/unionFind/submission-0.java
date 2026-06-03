class UnionFind {
    private int[] parent;
    private int[] size;
    private int count;
    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // path compression
    public int find(int p) {
        int root = p;
        while (root != parent[root]) root = parent[root];

        while (root != p) {
            int newP = parent[p];
            parent[p] = newP;
            p = newP;
        }
        return root;
    }

    public boolean isSameComponent(int x, int y) {
        return find(x) == find(y);
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return false;

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
        count--;
        return true;
    }

    public int getNumComponents() {
        return count;
    }
}
