class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && stack.peek() < temperature) {
                res[stackIndex.peek()] = i - stackIndex.peek();
                stack.pop();
                stackIndex.pop();
            }

            stack.push(temperature);
            stackIndex.push(i);
        }

        while (!stackIndex.isEmpty()) {
            res[stackIndex.pop()] = 0;
        }

        return res;
    }
}
