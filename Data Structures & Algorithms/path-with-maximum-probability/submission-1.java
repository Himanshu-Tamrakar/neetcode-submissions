 class Pair {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
}

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<Pair>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dst = edges[i][1];
            adj[src].add(new Pair(dst, succProb[i]));
            adj[dst].add(new Pair(src, succProb[i]));
        }
        
        PriorityQueue<Pair> max = new PriorityQueue<>((p1, p2) -> Double.compare(p2.prob, p1.prob));
        max.offer(new Pair(start_node, 1.0));


        Map<Integer, Double> distTo = new HashMap<>();

        while (!max.isEmpty()) {
            Pair curr = max.poll();
            
            int node = curr.node;
            double prob = curr.prob;

            if (node == end_node) {
                return prob;
            }

            if (distTo.containsKey(node)) {
                continue;
            }

            distTo.put(node, prob);

            for (Pair nei: adj[node]) {
                double new_prob = nei.prob * prob;

                if (!distTo.containsKey(nei.node)) {
                    max.offer(new Pair(nei.node, new_prob));
                }
            }

        }

        return 0.0;
    }
}