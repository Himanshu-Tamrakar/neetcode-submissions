class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch: s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != '[') {
                    return false;
                }
            } else if (ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != '{') {
                    return false;
                }
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != '(') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
