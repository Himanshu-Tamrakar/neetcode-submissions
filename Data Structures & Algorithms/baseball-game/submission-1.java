class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();
        int total = 0;

        for (String op : operations) {
            switch(op) {
                case "+": {
                    int a = stack.pop();
                    int b = stack.peek();
                    int sum = a + b;
                    stack.push(a);
                    stack.push(sum);
                    total += sum;
                    break;
                }
                case "D": {
                    int a = stack.peek();
                    int dbl = 2 * a;
                    stack.push(dbl);
                    total += dbl;
                    break;
                }
                case "C": {
                    int removed = stack.pop();
                    total -= removed;
                    break;
                }
                default: {
                    int val = Integer.parseInt(op);
                    stack.push(val);
                    total += val;
                    break;
                }
            
            }
        }
        
        return total;
        
    }
}