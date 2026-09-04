class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDist = 0;
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < arrays.size(); i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);
            maxDist = Math.max(
                maxDist,
                Math.max(
                    currMax - globalMin,
                    globalMax - currMin
                )
            );

            globalMin = Math.min(globalMin, currMin);
            globalMax = Math.max(globalMax, currMax);

        }

        return maxDist;
    }
}
