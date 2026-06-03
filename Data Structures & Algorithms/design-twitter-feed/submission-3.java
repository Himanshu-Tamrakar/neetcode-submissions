class Twitter {
    // [[1, [2]]]
    // [1, [10], [2, [20]]]
    private int count;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        count = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[] {count, tweetId});
        count++;
    }
    
    // Adding all tweet from userId and all following user's tweet and sorting.
    // Total Tweet = T (Sum of userId tweets + UserId Follow N User Each User Has M Tweets) = 
    // Total Qweets = m(total following users of userId) * n(Each following user has tweets) + k(total tweets user has)
    // public List<Integer> getNewsFeed(int userId) {
    //     List<int[]> feed = new ArrayList<>(tweetMap.getOrDefault(userId, new ArrayList<>()));
    //     for (int followeeId: followMap.getOrDefault(userId, new HashSet<>())) {
    //         feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
    //     }
    //     feed.sort((a, b) -> b[0] - a[0]);
        

    //     List<Integer> res = new ArrayList<>();
    //     for (int i = 0; i < Math.min(10, feed.size()); i++) {
    //         res.add(feed.get(i)[1]);
    //     }
    //     return res;
    // }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((t1, t2) -> t2[0] - t1[0]);

        // add current user recent tweet if has
        if (tweetMap.containsKey(userId)) {
            List<int[]> tweets = tweetMap.get(userId);
            int index = tweets.size() - 1;
            int[] tweet = tweets.get(index);
            minHeap.offer(new int[]{tweet[0], tweet[1], userId, index});
        }

        if (followMap.containsKey(userId)) {
                for (int followeeId : followMap.get(userId)) {
                if (tweetMap.containsKey(followeeId)) {
                    List<int[]> tweets = tweetMap.get(followeeId);
                    int index = tweets.size() - 1;
                    int[] tweet = tweets.get(index);
                    minHeap.offer(new int[]{tweet[0], tweet[1], followeeId, index});
                }
            }
        }
        

        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] curr = minHeap.poll();
            res.add(curr[1]);
            int index = curr[3];
            if (index > 0) {
                int[] tweet = tweetMap.get(curr[2]).get(index - 1);
                minHeap.offer(new int[]{tweet[0], tweet[1], curr[2], index - 1});
            }

        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}

