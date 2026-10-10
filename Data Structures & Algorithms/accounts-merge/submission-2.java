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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UF uf = new UF(n);
        Map<String, Integer> emailToAcc = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAcc.containsKey(email)) {
                    uf.union(i, emailToAcc.get(email));
                } else {
                    emailToAcc.put(email, i);
                }
            }
        }


        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for (Map.Entry<String, Integer> entry: emailToAcc.entrySet()) {
            String email = entry.getKey();
            int accId = entry.getValue();
            int component = uf.find(accId);
            emailGroup.putIfAbsent(component, new ArrayList<>());
            emailGroup.get(component).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry: emailGroup.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(emails);

            res.add(merged);
        }

        return res;


    }
}

