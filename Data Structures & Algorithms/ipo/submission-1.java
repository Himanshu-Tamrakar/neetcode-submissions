class Solution {
    private static class Node {
        int profit;
        int capital;
        public Node(int p, int c) {
            profit = p;
            capital = c;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        Node[] nodes = new Node[profits.length];

        PriorityQueue<Node> maxProf = new PriorityQueue<>((a, b) -> b.profit - a.profit); // Max Head based on profit
        PriorityQueue<Node> minCap = new PriorityQueue<>((a, b) -> a.capital - b.capital); // Min Head based on capital

        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], capital[i]);

            if (capital[i] <= w) maxProf.offer(nodes[i]); // if capital is leff or equal current wealth
            else minCap.offer(nodes[i]); // else
        }

        while (k > 0) {
            
            // Add if we can add into maxProf head based on current w
            while(!minCap.isEmpty() && minCap.peek().capital <= w) {
                maxProf.offer(minCap.poll());
            }

            // get latest profitable project based on current wealth
            if (!maxProf.isEmpty()) {
                w += maxProf.poll().profit;
            }

            k--;
        }

        return w;
        
    }
}