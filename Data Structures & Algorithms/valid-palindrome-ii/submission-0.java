class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length()-1, true);
    }

    private boolean validPalindrome(String s, int i, int j, boolean skip) {
        if (i >= j) return true;

        if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
            return validPalindrome(s, i + 1, j - 1, skip);
        }
        if (!skip) {
            return false;
        }
        return validPalindrome(s, i + 1, j, false) || validPalindrome(s, i, j - 1, false);
    }
}