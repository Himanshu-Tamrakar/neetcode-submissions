class Solution {
    // class Node implements Comparable<Node> {
    //     int index;
    //     int val;
    //     int target;

    //     public Node(int i, int v, int t) {
    //         this.index = i;
    //         this.val = v;
    //         this.target = t;
    //     }

    //     public int getVal() {return this.val;}

    //     @Override
    //     public int compareTo(Node that) {
    //         if (Math.abs(this.val - this.target) < Math.abs(that.val - that.target)) return -1;
    //         if (Math.abs(this.val - this.target) == Math.abs(that.val - that.target)) {
    //             if (this.index < that.index) return -1;
    //             else return 1;
    //         }
    //         return 1;
    //     }
    // }
    // public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //     PriorityQueue<Node> pq = new PriorityQueue<>();
    //     for (int i = 0; i < arr.length; i++) {
    //         pq.offer(new Node(i, arr[i], x));
    //     }


    //     int[] res = new int[k];
    //     int i = 0;
    //     while(i < k) {
    //         Node x1 = pq.poll();
    //         res[i] = x1.getVal();
    //         i++;
    //     }
    //     Arrays.sort(res);

    //     List<Integer> result = new ArrayList<>();
    //     for (int v : res) result.add(v);
    // return result;
    // }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int lo = 0, hi = arr.length - 1;
        int pos = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (x < arr[mid]) {
                hi = mid - 1;
            } else if (x > arr[mid]) {
                lo = mid + 1;
            } else {
                pos = mid;
                break;
            }
        }

        if (pos == -1) {
            if (hi < 0) {
                pos = lo;
            } else if (lo == arr.length) {
                pos = hi;
            } else {
                if (Math.abs(arr[lo] - x) < Math.abs(x - arr[hi])) {
                    pos = lo;
                } else if (Math.abs(arr[lo] - x) < Math.abs(x - arr[hi])) {
                    pos = hi;
                } else {
                    pos = lo < hi ? lo : hi;
                }
            }
        }    

        res.add(arr[pos]);

        int l = pos - 1;
        int r = pos + 1;

        if (l < 0) {
            while (res.size() < k) res.add(arr[r++]);
        } else if (r == arr.length) {
            while (res.size() < k) res.add(arr[l--]);
        } else {
            while (res.size() < k) {

                if (l >= 0 && ((x - arr[l]) <= (arr[r] - x))) {
                    res.add(arr[l]);
                    l--;
                } 
                else if (r < arr.length) {
                    res.add(arr[r]);
                    r++;
                }
            }
        }

        for(int num: res) System.out.println(num);
        Collections.sort(res);

        return res;
}
}