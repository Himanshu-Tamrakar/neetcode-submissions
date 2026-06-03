class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                if (ch == ')') {
                    char prevOprt = stack.pop();
                    if (prevOprt != '(') return false;
                } else if (ch == '}') {
                    char prevOprt = stack.pop();
                    if (prevOprt != '{') return false;
                } else if (ch == ']') {
                    char prevOprt = stack.pop();
                    if (prevOprt != '[') return false;
                } 
            }
        }

        return stack.isEmpty();
    }
}
