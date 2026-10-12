class MedianFinder {
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Comparator.reverseOrder());
        // max = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        // max = new PriorityQueue<>(new Comparator<Integer>() {
        //     @override
        //     public int compare(int a, int b) {
        //         return Integer.compare(b, a);
        //     }
        // })
    }
    
    // [1,2,3,4,5]
    // Maintain MaxQ first Half
    // Maintain MinQ with second half of sorted array
    public void addNum(int num) {
        max.offer(num);
        if (!min.isEmpty() && max.peek() > min.peek()) {
            min.offer(max.poll());
        }

        if (max.size() - min.size() > 1) {
            min.offer(max.poll());
        } else if (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }
    }
    
    public double findMedian() {
        if (min.size() == max.size()) {
            return (double) (min.peek() + max.peek()) / 2.0;
        } else if (min.size() > max.size()) {
            return (double) min.peek();
        } else {
            return (double) (max.peek());
        }
    }
}
