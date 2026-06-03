class Point {
    int x, y, index;
    public Point(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
   
}

class Line implements Comparable<Line> {
    Point point1; Point point2;
    int distance;
    public Line(Point p1, Point p2) {
        this.point1 = p1;
        this.point2 = p2;
        this.distance = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
    
    @Override
    public int compareTo(Line that) {
        return Integer.compare(this.distance, that.distance);
    }
}
class Solution {
    private PriorityQueue<Line> pq;
    private boolean[] marked;
    private int n;
    private int[][] points;
    private List<Line> mst;
    public int minCostConnectPoints(int[][] points) {
        this.points = points;
        this.n = points.length;
        pq = new PriorityQueue<>();
        marked = new boolean[this.n];
        mst = new ArrayList<>();

        visit(new Point(points[0][0], points[0][1], 0));

        int res = 0;

        while(!pq.isEmpty() && mst.size() < this.n-1) {
            Line line = pq.remove();
            
            if (marked[line.point1.index] && marked[line.point2.index]) continue;
            mst.add(line);
            res += line.distance;
            if (!marked[line.point1.index]) visit(line.point1);
            if (!marked[line.point2.index]) visit(line.point2);
        }

        return res;
        
        
    }

    private void visit(Point p) {
        marked[p.index] = true;

        for (int i = 0; i < n; i++) {
            if (marked[i]) continue;
            
            int x = this.points[i][0];
            int y = this.points[i][1];
            Point p2 = new Point(x, y, i);
            pq.offer(new Line(p, p2));
        }
    }
}
