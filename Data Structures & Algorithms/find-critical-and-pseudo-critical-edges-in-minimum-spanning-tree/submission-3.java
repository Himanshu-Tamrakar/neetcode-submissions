class UF {
    private int[] parent;
    private int[] size;
    private int count;

    public UF(int n) {
        this.parent = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
        this.count = n;
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

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int components() {
        return this.count;
    }
}

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<int[]> edgeList = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            edgeList.add(new int[] {edges[i][0], edges[i][1], edges[i][2], i});
        }
        edgeList.sort(Comparator.comparingInt(a -> a[2]));

        int mstWeight = 0;
        UF uf = new UF(n);
        for (int[] edge : edgeList) {
            if (!uf.connected(edge[0], edge[1])) {
                uf.union(edge[0], edge[1]);
                mstWeight += edge[2];
            }
        }

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int[] edge : edgeList) {
            uf = new UF(n);
            int weight = 0;

            for (int[] other : edgeList) {
                if (edge[3] == other[3]) {
                    continue;
                }
                if (uf.connected(other[0], other[1])) {
                    continue;
                }
                uf.union(other[0], other[1]);
                weight += other[2];
            }

            if (uf.components() != 1 || weight > mstWeight) {
                critical.add(edge[3]);
                continue;
            }

            // Try for pseodu edge when current edge is not critical
            uf = new UF(n);
            uf.union(edge[0], edge[1]);
            weight = edge[2];
            for (int[] other: edgeList) {
                if (!uf.connected(other[0], other[1])) {
                    uf.union(other[0], other[1]);
                    weight += other[2];
                }
            }
            if (weight == mstWeight) {
                pseudo.add(edge[3]);
            }
        }

        return Arrays.asList(critical, pseudo);
        
    }
}