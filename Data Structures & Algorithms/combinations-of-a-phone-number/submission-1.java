class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        
        Map<Character, String> mapping = new HashMap();
        mapping.put('2', "abc");
        mapping.put('3', "def");
        mapping.put('4', "ghi");
        mapping.put('5', "jkl");
        mapping.put('6', "mno");
        mapping.put('7', "pqrs");
        mapping.put('8', "tuv");
        mapping.put('9', "wxyz");
        StringBuilder s = new StringBuilder();

        letterCombinations(digits, mapping, 0, s, res);
        return res;
        
    }

    private void letterCombinations(String digits, Map<Character, String> mappings, int i, StringBuilder curr, List<String> res) {
        
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        }

        if (i == digits.length()) {
            return;
        }
      

        String str = mappings.get(digits.charAt(i));

        for (char ch: str.toCharArray()) {
            curr.append(ch);
            letterCombinations(digits, mappings, i+1, curr, res);
            curr.deleteCharAt(curr.length()-1);
        }

    }
}
