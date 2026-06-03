class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String ops : operations) {
            if (ops.equals("+")) {
                int val = stack.pop();
                int res = stack.peek() + val;

                stack.push(val);
                stack.push(res);
            } else if (ops.equals("D")) {
                int val = stack.pop();
                int res = val * 2;
                stack.push(val);
                stack.push(res);
            } else if (ops.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(ops));
            }
        }
        
        int res = 0;
        for (int val: stack) res += val;

        return res;
        
    }
}