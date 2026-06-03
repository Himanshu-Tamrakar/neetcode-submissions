class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone: stones) {
            maxPQ.offer(stone);
        }

        while (maxPQ.size() > 1) {
            int stone1 = maxPQ.poll();
            int stone2 = maxPQ.poll();
            int res = stone1 - stone2;
            if (res > 0) {
                maxPQ.offer(res);
            }
            
        }

        return maxPQ.size() == 0 ? 0 : maxPQ.poll();
    }
}
