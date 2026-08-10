class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int i = 0;
        int n = sandwiches.length;
        Queue<Integer> queueOfStudents = new ArrayDeque<>();

      
        for (int j = 0; j < students.length; j++) {
            queueOfStudents.offer(students[j]);
        }

        while (i < n) {
            if (sandwiches[i] == queueOfStudents.peek()) {
                i++;
                queueOfStudents.poll();
            } else {
                Queue<Integer> tempQueueOfStudents = new ArrayDeque<>();
                while(!queueOfStudents.isEmpty() && (queueOfStudents.peek() != sandwiches[i])) {
                    tempQueueOfStudents.offer(queueOfStudents.poll());
                }
                if (queueOfStudents.isEmpty()) {
                    return tempQueueOfStudents.size();
                } else {
                    while(!tempQueueOfStudents.isEmpty()) {
                        queueOfStudents.offer(tempQueueOfStudents.poll());
                    }
                }
            }
        }

        return 0;
    }
}
