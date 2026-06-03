class DirectedEdge {
    private int v, w;
    private double weight;
    public DirectedEdge(int v, int w, double weight){
        if (v < 0) throw new IllegalArgumentException("from vertex can't be < 0");
        if (w < 0) throw new IllegalArgumentException("to vertex can't be < 0");
        if (weight < 0) throw new IllegalArgumentException("Negetive weight not allowed");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int from() {return this.v;}
    public int to() {return this.w;}
    public double weight() {return this.weight;}
    public String toString() {
        return this.v + " - > " + this.w + " " + this.weight;
    }
}

class EdgeWeightedDigraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private int V;
    private int E;
    List<DirectedEdge>[] adj;
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<DirectedEdge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<DirectedEdge>();
        }
    }
    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        validate(v);
        validate(w);
        this.adj[v].add(e);
        this.E++;
    }
    public Iterable<DirectedEdge> adj(int v) {
        validate(v);
        return this.adj[v];
    }
    public int V() {return this.V;}
    public int E() {return this.E;}
    private void validate(int v) {
        if (v < 0 || v >= this.V) throw new IllegalArgumentException("");
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(this.V + " " + this.E + NEWLINE);
        for (int v = 0; v < this.V; v++) {
            s.append(v + ": ");
            for(DirectedEdge e: this.adj[v]) {
                s.append(e + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}

public class IndexMaxPQ<Key extends Comparable<Key>> {
    private int maxN;        // maximum number of elements on PQ
    private int n;           // number of elements on PQ
    private int[] pq;        // binary heap using 1-based indexing
    private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
    private Key[] keys;      // keys[i] = priority of i

    public IndexMaxPQ(int maxN) {
        if (maxN < 0) throw new IllegalArgumentException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];    // make this of length maxN??
        pq   = new int[maxN + 1];
        qp   = new int[maxN + 1];                   // make this of length maxN??
        for (int i = 0; i <= maxN; i++)
            qp[i] = -1;
    }

 
    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        validateIndex(i);
        return qp[i] != -1;
    }

    public int size() {
        return n;
    }

 
    public void insert(int i, Key key) {
        validateIndex(i);
        if (contains(i)) throw new IllegalArgumentException("index is already in the priority queue");
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }
   
    public int delMax() {
        if (n == 0) throw new NoSuchElementException("Priority queue underflow");
        int max = pq[1];
        exch(1, n--);
        sink(1);

        assert pq[n+1] == max;
        qp[max] = -1;        // delete
        keys[max] = null;    // to help with garbage collection
        pq[n+1] = -1;        // not needed
        return max;
    }
  
    public void increaseKey(int i, Key key) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) == 0)
            throw new IllegalArgumentException("Calling increaseKey() with a key equal to the key in the priority queue");
        if (keys[i].compareTo(key) > 0)
            throw new IllegalArgumentException("Calling increaseKey() with a key that is strictly less than the key in the priority queue");

        keys[i] = key;
        swim(qp[i]);
    }

  
    public void decreaseKey(int i, Key key) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
        if (keys[i].compareTo(key) == 0)
            throw new IllegalArgumentException("Calling decreaseKey() with a key equal to the key in the priority queue");
        if (keys[i].compareTo(key) < 0)
            throw new IllegalArgumentException("Calling decreaseKey() with a key that is strictly greater than the key in the priority queue");
        keys[i] = key;
        sink(qp[i]);
    }

    // throw an IllegalArgumentException if i is an invalid index
    private void validateIndex(int i) {
        if (i < 0) throw new IllegalArgumentException("index is negative: " + i);
        if (i >= maxN) throw new IllegalArgumentException("index >= capacity: " + i);
    }

   /***************************************************************************
    * General helper functions.
    ***************************************************************************/
    private boolean less(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

   /***************************************************************************
    * Heap helper functions.
    ***************************************************************************/
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}

class Solution {
    private EdgeWeightedDigraph digraph;
    private IndexMaxPQ<Double> pq;
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        distTo = new double[n];
        edgeTo = new DirectedEdge[n];
        for (int v = 0; v < n; v++) {
            distTo[v] = Double.MIN_VALUE;
        }
        distTo[start_node] = 1;

        digraph = new EdgeWeightedDigraph(n);
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int v = edge[0];
            int w = edge[1];
            double weight = succProb[i];
            DirectedEdge e1 = new DirectedEdge(v, w, weight);
            DirectedEdge e2 = new DirectedEdge(w, v, weight);
            digraph.addEdge(e1);
            digraph.addEdge(e2);
        }
        pq = new IndexMaxPQ<>(n);
        pq.insert(start_node, distTo[start_node]);
        
        while(!pq.isEmpty()) {
            int v = pq.delMax();
            System.out.println("delMax: " + v);
            if (v == end_node) break;
            for (DirectedEdge e: digraph.adj(v)) {
                System.out.println("adjecents: " + e);
                if (e.to() == start_node) continue;
                relax(e);
            }
        }
        return distTo[end_node];

    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        
        if (distTo[w] < distTo[v] * e.weight()) {
            distTo[w] = distTo[v] * e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) pq.increaseKey(w, distTo[w]);
            else pq.insert(w, distTo[w]);
        }
    }
}