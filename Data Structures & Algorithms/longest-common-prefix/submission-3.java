class Solution {
    public String longestCommonPrefix(String[] strs) {

        String small = strs[0];
        for (String str: strs) {
            if (str.length() < small.length()) small = str;
        }

        System.out.println(small);

        int len = 0;
        boolean stop = false;
        for (; len < small.length() && !stop; len++) {
            char ch = small.charAt(len);
            for (String str: strs) {

                if (ch != str.charAt(len)) {
                    len--;
                    stop = true;
                    break;

                }
                

            }
        }

        return small.substring(0, Math.max(len, 0));
        
    }
}