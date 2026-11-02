class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i < currentState.length(); i++) {
            if (currentState.charAt(i-1) == '+' && currentState.charAt(i) == '+') {
                StringBuilder s = new StringBuilder(currentState);
                s.setCharAt(i-1, '-');
                s.setCharAt(i, '-');
                result.add(s.toString());
            }
        }
        return result;
    }
}
