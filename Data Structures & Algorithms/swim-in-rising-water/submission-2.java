

class Solution {
    private static class Node implements Comparable<Node> {
        int r, c, weight; 
        public Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node that) {
            return Integer.compare(this.weight, that.weight);
        }
    }
    
    
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        boolean[][] visit = new boolean[m][m];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, grid[0][0]));

        visit[0][0] = true;
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!pq.isEmpty()) {
            Node x = pq.remove();
            int r = x.r;
            int c = x.c;
            int weight = x.weight;
            if (r == m-1 && c == m-1) return weight;

            for (int[] move: moves) {
                int dr = move[0];
                int dc = move[1];
                int neiR = r + dr;
                int neiC = c + dc;

                if (neiR < 0 || neiC < 0 || neiR == m || neiC == m) {
                    continue;
                }
                if (visit[neiR][neiC]) {
                    continue;
                }
                visit[neiR][neiC] = true;
                pq.offer(new Node(neiR, neiC, Math.max(grid[neiR][neiC], weight)));
            }
          
        }
        return -1;
    }
}
