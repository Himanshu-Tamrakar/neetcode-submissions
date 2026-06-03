class Solution {

    public int evalRPN(String[] tokens) {
        Stack<String> oprt = new Stack<>();
        Stack<Integer> oprd = new Stack<>();
        for (String token: tokens) {
            if (token.equals("+")) {
                int v1 = oprd.pop();
                int v2 = oprd.pop();
                int res = v1 + v2;
                oprd.push(res);
            }
            else if (token.equals("-")) {
                int v1 = oprd.pop();
                int v2 = oprd.pop();
                int res = v2 - v1;
                oprd.push(res);
            }
            else if (token.equals("*")) {
                int v1 = oprd.pop();
                int v2 = oprd.pop();
                int res = v1 * v2;
                oprd.push(res);
            }
            else if (token.equals("/")) {
                int v1 = oprd.pop();
                int v2 = oprd.pop();
                int res = v2 / v1;
                oprd.push(res);
            }
            else {
                int val = Integer.parseInt(token);
                oprd.push(val);
            }
        }
        return oprd.pop();
    }
}
