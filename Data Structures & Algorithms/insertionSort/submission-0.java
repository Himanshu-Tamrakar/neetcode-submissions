// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {

        int n = pairs.size();
        List<List<Pair>> res = new ArrayList();

        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(pairs.get(j), pairs.get(j-1)); j--) {
                exch(pairs, j, j-1);
            }
            List<Pair> cloneList = new ArrayList<>(pairs);
            res.add(cloneList);
        }
        return res;
    

    }

    private boolean less(Pair pair1, Pair pair2) {
        return pair1.key < pair2.key;
    }

    private void exch(List<Pair> pairs, int i, int j) {
        Pair temp = pairs.get(j);
        pairs.set(j, pairs.get(j + 1));
        pairs.set(j + 1, temp);   
    }
}
