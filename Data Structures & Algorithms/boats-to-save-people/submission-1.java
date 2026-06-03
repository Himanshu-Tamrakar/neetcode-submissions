class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        Arrays.sort(people);
        int res = 0;
        int l = 0;
        for (int i = n -1; i >= l; i--) {
            if (people[i] == limit) {
                res += 1;
            } else {
                if (i > 0 && (people[i] + people[i - 1] <= limit)) {
                    i--;
                    res += 1;
                } else if (people[i] + people[l] <= limit) {
                    l++;
                    res += 1;
                } else {
                    res += 1; 
                }
            }
        }
        return res;
    }
}