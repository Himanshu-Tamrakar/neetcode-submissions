class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> stackOfSandwiches = new ArrayDeque<>();
        Queue<Integer> queueOfStudents = new ArrayDeque<>();

        for (int i = sandwiches.length-1; i >= 0; i--) {
            stackOfSandwiches.push(sandwiches[i]);
        }
        for (int i = 0; i < students.length; i++) {
            queueOfStudents.offer(students[i]);
        }

        while (!stackOfSandwiches.isEmpty()) {
            if (stackOfSandwiches.peek() == queueOfStudents.peek()) {
                stackOfSandwiches.pop();
                queueOfStudents.poll();
            } else {
                Queue<Integer> tempQueueOfStudents = new ArrayDeque<>();
                while(!queueOfStudents.isEmpty() && (queueOfStudents.peek() != stackOfSandwiches.peek())) {
                    tempQueueOfStudents.offer(queueOfStudents.poll());
                }
                if (queueOfStudents.isEmpty()) {
                    System.out.println(tempQueueOfStudents.size());
                    return tempQueueOfStudents.size();
                } else {
                    System.out.println(tempQueueOfStudents.size());
                    while(!tempQueueOfStudents.isEmpty()) {
                        queueOfStudents.offer(tempQueueOfStudents.poll());
                    }
                }
            }
        }

        return 0;
    }
}
