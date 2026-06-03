class Digraph {
    private final static String NEWLINE = System.getProperty("line.separator");
    private int V;
    private List<Integer>[] adj;
    public Digraph(int V) {
        this.V = V;
        this.adj = new ArrayList[V];
        for (int v = 0; v < V; v++) {
            this.adj[v] = new ArrayList<>();
        }
    }
    public int V() { return this.V; }
    public void addEdge(int v, int w) {
        this.adj[v].add(w);
    }
    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }
    public int size(int v) {
        return this.adj[v].size();
    }

     public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices " + NEWLINE);
        for (int v = 0; v < V; v++) {
            if (adj[v].size() > 0) s.append(String.format("%d: ", v));
            for (int w : adj[v]) {
                s.append(String.format("%d ", w));
            }
            if (adj[v].size() > 0) s.append(NEWLINE);
        }
        return s.toString();
    }
}
class DirectedCycle {
    private boolean[] marked;
    private boolean[] onStack;
    private boolean isCycle;
    public DirectedCycle(Digraph digraph) {
        marked  = new boolean[digraph.V()];
        onStack = new boolean[digraph.V()];
        for (int v = 0; v < digraph.V(); v++)
            if (!marked[v] && !isCycle) dfs(digraph, v);
    }

    private void dfs(Digraph digraph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            // short circuit if directed cycle found
            if (isCycle) return;

            // trace back directed cycle
            else if (onStack[w]) {
                isCycle = true;
                return;
            }

            // found new vertex, so recur
            else if (!marked[w]) {
                dfs(digraph, w);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return isCycle;
    }
}
class DepthFirstOrder {
    private Queue<Integer> postorder;
    private boolean[] marked;
    public DepthFirstOrder(Digraph graph, Iterable<Integer> sources) {
        postorder = new ArrayDeque<>();
        marked = new boolean[graph.V()];
        for (int v: sources) {
            if (!marked[v]) dfs(graph, v);
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        for (int w:  graph.adj(v)) {
            if (w == v) continue;
            if (!marked[w]) dfs(graph, w);
        }
        postorder.offer(v);
    }

    public Iterable<Integer> postOrder() {
        return this.postorder;
    }
    public Iterable<Integer> reversePost() {
        Deque<Integer> reverse = new ArrayDeque<>();
        for (int v: postorder) reverse.push(v);
        return reverse;
    }
}

class Solution {
    private final int R = 256;
    private Digraph graph;
    public String foreignDictionary(String[] words) {
        graph = new Digraph(R);
        Set<Integer> unique = new HashSet<>();

        for (String word: words) {
            for (int ch: word.toCharArray()) {
                unique.add(ch);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i-1];
            String word2 = words[i];

            int sz = Math.min(word1.length(), word2.length());

            if (word1.length() > word2.length() && word1.substring(0, sz).equals(word2))  {
                return "";
            }
            

            for (int j = 0; j < sz; j++) {
                int v = word1.charAt(j);
                int w = word2.charAt(j);
                if (v == w) continue;
                graph.addEdge(v, w);
                break;
            }
        }

        StringBuilder s = new StringBuilder();

        DirectedCycle finder = new DirectedCycle(graph);
        if (finder.hasCycle()) {
            return s.toString();
        }

        DepthFirstOrder dfs = new DepthFirstOrder(graph, unique);
        for (int v: dfs.reversePost()) s.append((char)v);

        return s.toString();
    }
    
}