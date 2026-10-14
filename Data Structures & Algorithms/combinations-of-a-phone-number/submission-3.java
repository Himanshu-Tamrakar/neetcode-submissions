class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        Map<Character, String> numToChars = new HashMap<>();
        numToChars.put('2', "abc");
        numToChars.put('3', "def");
        numToChars.put('4', "ghi");
        numToChars.put('5', "jkl");
        numToChars.put('6', "mno");
        numToChars.put('7', "pqrs");
        numToChars.put('8', "tuv");
        numToChars.put('9', "wxyz");
        String[] inputs = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            inputs[i] = numToChars.get(digits.toCharArray()[i]);
        }
        StringBuilder s = new StringBuilder();
        dfs(inputs, 0, s, res);
        return res;
    }

    private void dfs(String[] inputs, int i, StringBuilder s, List<String> res) {
        if (s.length() == inputs.length) {
            res.add(s.toString());
            return;
        }

        if (i == inputs.length) {
            return;
        }

        for (int j = 0; j < inputs[i].length(); j++) {
            String input = inputs[i];
            s.append(input.charAt(j));
            dfs(inputs, i + 1, s, res);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
