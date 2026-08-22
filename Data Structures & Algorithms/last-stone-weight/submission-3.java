class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int stone: stones) {
            maxPQ.offer(stone);
        }

        while (maxPQ.size() > 1) {
            int first = maxPQ.poll();
            int second = maxPQ.poll();

            if (first < second) {
                maxPQ.offer(second - first);
            } else if (first > second) {
                maxPQ.offer(first - second);
            } 
        }

        return maxPQ.size() > 0 ? maxPQ.peek() : 0;
    }
}
