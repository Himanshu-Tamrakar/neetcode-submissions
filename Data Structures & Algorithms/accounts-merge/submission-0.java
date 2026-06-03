class Solution {
    private int[] parent;
    private int[] size;
    private int count;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[accounts.size()];
        size = new int[accounts.size()];
        count = accounts.size();

        for (int i = 0; i < accounts.size(); i++) {
            parent[i] = i;
            size[i] = 1;
        }

        Map<String, Integer> map = new HashMap();

        for (int i = 0; i < accounts.size(); i++) {

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
            
                String email = account.get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                } else {
                    union(i, map.get(email));
                }
            }
        }

        Map<Integer, Set<String>> res = new HashMap();
        for (int i = 0; i < accounts.size(); i++) {
            int root = find(i);
            if (!res.containsKey(root)) {
                res.put(root, new HashSet());
            } 

            int j = 1;
            while (j < accounts.get(i).size()) {
                res.get(root).add(accounts.get(i).get(j));
                j++;
            }

        }

        List<List<String>> res1 = new ArrayList();
        
        for (Map.Entry<Integer, Set<String>> entry : res.entrySet()) {
            ArrayList<String> acc = new ArrayList();

            Integer key = entry.getKey();
            Set<String> values = entry.getValue();
            String[] sortedValues = values.toArray(new String[0]);
            Arrays.sort(sortedValues);

            acc.add(accounts.get(key).get(0));
            for (String value : sortedValues) {
                acc.add(value);
            }
            res1.add(acc);

        }

        return res1;

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