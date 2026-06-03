class Solution {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char c: s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                stringStack.push(curr.toString());
                countStack.push(k);
                curr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                String temp = curr.toString();
                curr = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    curr.append(temp);
                }
            } else {
                curr.append(c);
            }
        }

        return curr.toString();

        
    }
}