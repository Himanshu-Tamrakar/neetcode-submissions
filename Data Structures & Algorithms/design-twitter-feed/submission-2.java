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
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>(tweetMap.getOrDefault(userId, new ArrayList<>()));
        for (int followeeId: followMap.getOrDefault(userId, new HashSet<>())) {
            feed.addAll(tweetMap.getOrDefault(followeeId, new ArrayList<>()));
        }
        feed.sort((a, b) -> b[0] - a[0]);
        

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(10, feed.size()); i++) {
            res.add(feed.get(i)[1]);
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

