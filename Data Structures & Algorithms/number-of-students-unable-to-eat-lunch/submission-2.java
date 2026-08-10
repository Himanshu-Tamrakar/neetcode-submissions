class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int res = n;
        int[] cnt = new int[2];
        for (int i = 0; i < n; i++) {
            cnt[students[i]]++;
        }

        for (int i = 0; i < n; i++) {
            if (cnt[sandwiches[i]] > 0) {
                res--;
                cnt[sandwiches[i]]--;
            } else {
                break;
            }
        }

        return res;
    }

    // O(n) Space, O(n^2) Time
    // public int countStudents(int[] students, int[] sandwiches) {
    //     int i = 0;
    //     int n = sandwiches.length;
    //     Queue<Integer> queueOfStudents = new ArrayDeque<>();
    //     for (int j = 0; j < students.length; j++) {
    //         queueOfStudents.offer(students[j]);
    //     }

    //     while (i < n) {
    //         if (sandwiches[i] == queueOfStudents.peek()) {
    //             i++;
    //             queueOfStudents.poll();
    //         } else {
    //             Queue<Integer> tempQueueOfStudents = new ArrayDeque<>();
    //             while(!queueOfStudents.isEmpty() && (queueOfStudents.peek() != sandwiches[i])) {
    //                 tempQueueOfStudents.offer(queueOfStudents.poll());
    //             }
    //             if (queueOfStudents.isEmpty()) {
    //                 return tempQueueOfStudents.size();
    //             } else {
    //                 while(!tempQueueOfStudents.isEmpty()) {
    //                     queueOfStudents.offer(tempQueueOfStudents.poll());
    //                 }
    //             }
    //         }
    //     }

    //     return 0;
    // }
}
