class MedianFinder {
    private PriorityQueue<Integer> maxPQ;
    private PriorityQueue<Integer> minPQ;
    public MedianFinder() {
        maxPQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minPQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxPQ.offer(num);
        if (maxPQ.size() > (minPQ.size() + 1)) {
            minPQ.offer(maxPQ.remove());
        }

        if (maxPQ.size() > 0 && minPQ.size() > 0 && (maxPQ.peek() > minPQ.peek())) {
            minPQ.offer(maxPQ.remove());
        }

        if (minPQ.size() > (maxPQ.size() + 1)) {
            maxPQ.offer(minPQ.remove());
        }
    }
    
    public double findMedian() {
        if (maxPQ.size() == minPQ.size()) {
            return (maxPQ.peek() + minPQ.peek()) / 2.0;
        }

        if (maxPQ.size() > minPQ.size()) {
            return (double) maxPQ.peek();
        } else {
            return (double) minPQ.peek();
        }
    }
}
