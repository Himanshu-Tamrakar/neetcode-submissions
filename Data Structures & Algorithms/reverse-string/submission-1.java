class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;

        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
        
    }

    private void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}