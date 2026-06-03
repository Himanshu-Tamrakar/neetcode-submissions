class Solution {
    /**
    * O(N * (M + 26))
    */
    // public boolean checkInclusion(String s1, String s2) {
    //     for (int i = 0; i < s2.length(); i++) {
    //         int[] count = new int[26];
    //         for (int c = 0; c < s1.length(); c++) {
    //             count[s1.charAt(c) - 'a']++;
    //         }

    //         for (int j = i; j < Math.min(s2.length(), i + s1.length()); j++) {
    //             count[s2.charAt(j) - 'a']--;
    //         }

    //         int check = 0;
    //         for (int j = 0; j < 26; j++) {
    //             if (count[j] == 0) {
    //                 check++;
    //             }
    //         }

    //         if (check == 26) return true;
    //     }
    //     return false;   
    // }

    /**
    * O(N * (M + 26))
    */
    public boolean checkInclusion(String s1, String s2) {
        for (int i = 0; i < s2.length(); i++) {
            int[] count = new int[26];
            for (int c = 0; c < s1.length(); c++) {
                count[s1.charAt(c) - 'a']++;
            }

            for (int j = i; j < Math.min(s2.length(), i + s1.length()); j++) {
                if (count[s2.charAt(j) - 'a'] == 0) break;
                count[s2.charAt(j) - 'a']--;
            }

            int check = 0;
            for (int j = 0; j < 26; j++) {
                if (count[j] == 0) {
                    check++;
                }
            }

            if (check == 26) return true;
        }
        return false;   
    }
}
