class Solution {

    // public boolean validPalindrome(String s) {
    //     if (isPalindrome(s));

    //     for (int i = 0; i < s.length(); i++) {
    //         String strNew = s.substring(0, i) + s.substring(i + 1, s.length());
    //         if (isPalindrome(strNew)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // private boolean isPalindrome(String s) {
    //     int left = 0, right = s.length() - 1;
    //     while (left < right) {
    //         if (s.charAt(left) != s.charAt(right)) {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // }

    // public boolean validPalindrome(String s) {
    //     return validPalindrome(s, 0, s.length()-1, true);
    // }

    // private boolean validPalindrome(String s, int i, int j, boolean skip) {
    //     if (i >= j) return true;

    //     if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
    //         return validPalindrome(s, i + 1, j - 1, skip);
    //     }
    //     if (!skip) {
    //         return false;
    //     }
    //     return validPalindrome(s, i + 1, j, false) || validPalindrome(s, i, j - 1, false);
    // }

    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }


    private boolean isPalindrome(String s, int i, int j) {
        int l = i;
        int r = j;

        while (l < r) {
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}