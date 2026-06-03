class Solution {
    class Node implements Comparable<Node> {
        private int index;
        int val;
        int target;

        public Node(int i, int v, int t) {
            this.index = i;
            this.val = v;
            this.target = t;
        }

        public int getVal() {return this.val;}

        @Override
        public int compareTo(Node that) {
            if (Math.abs(this.val - this.target) < Math.abs(that.val - that.target)) return -1;
            if (Math.abs(this.val - this.target) == Math.abs(that.val - that.target)) {
                if (this.index < that.index) return -1;
                else return 1;
            }
            return 1;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new Node(i, arr[i], x));
        }


        int[] res = new int[k];
        int i = 0;
        while(i < k) {
            Node x1 = pq.poll();
            res[i] = x1.getVal();
            i++;
        }
        Arrays.sort(res);

        List<Integer> result = new ArrayList<>();
        for (int v : res) result.add(v);
        return result;
    }
}