class Solution {
    class Node {
        private int profit;
        private int capital;
        public Node(int p, int c) {
            profit = p;
            capital = c;
        }

        // Comparator for sorting by capital (ascending)
        static Comparator<Node> byCapital = (a, b) -> Integer.compare(a.capital, b.capital);
    
        // Comparator for sorting by profit (descending - max heap)
        static Comparator<Node> byProfit = (a, b) -> Integer.compare(b.profit, a.profit);
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(profits[i], capital[i]);
        }

        Arrays.sort(nodes, Node.byCapital);
        PriorityQueue<Node> max = new PriorityQueue<>(Node.byProfit);
        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < n && w >= nodes[idx].capital) {
                max.offer(nodes[idx]);
                idx++;
            }
            if (max.isEmpty()) break;

            w += max.poll().profit;
        }
        return w;

    }
}