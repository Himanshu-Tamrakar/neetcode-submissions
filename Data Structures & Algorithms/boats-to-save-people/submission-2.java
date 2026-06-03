class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int res = 0;
        int l = 0; 
        int r = people.length - 1;

        while (l <= r) {
            int remain = limit - people[r];
            res++;

            if (l < r && people[r-1] <= remain) {
                r--;
            } else if (l < r && people[l] <= remain) {
                l++;
            }
            r--;
        }
        return res;
    }
}