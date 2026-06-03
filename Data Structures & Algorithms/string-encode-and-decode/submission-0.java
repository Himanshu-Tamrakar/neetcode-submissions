class Solution {
    private final String delimeter = "#";
    public String encode(List<String> strs) {
        String encodedString = "";
        for (String str : strs) {
            int len = str.length();
            encodedString += len + delimeter + str;
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> decodedRes = new ArrayList<>();
        int i = 0;
        int l = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch == '#') {
                int len = Integer.parseInt(str.substring(l, i));
                String s = str.substring(i+1, i + len + 1);
                decodedRes.add(s);
                l = i + len + 1;
                i = i + len;
            }
            i++;
        }

        return decodedRes;
    }
}
