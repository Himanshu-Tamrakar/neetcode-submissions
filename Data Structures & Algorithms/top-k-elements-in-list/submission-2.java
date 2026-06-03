class Solution {
    class Node implements Comparable<Node> {
        int key;
        int val;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
        @Override
        public int compareTo(Node that) {
            return Integer.compare(this.val, that.val);
        }

    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        int index = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, 1 + count.getOrDefault(num, 0));
        }

        for (Map.Entry<Integer, Integer> e: count.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();

            pq.offer(new Node(key, val));
            if (pq.size() == k + 1) pq.poll();
        }

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            res[index++] = node.key;
        }

        return res;
    }
}
