class SnakeGame {
    private int rows, cols;
    private Queue<int[]> snake;
    private int[][] food;
    private int currRow;
    private int currCol;
    private int score;
    private int foodIdx;

    public SnakeGame(int width, int height, int[][] food) {
        rows = height;
        cols = width;
        snake = new LinkedList<>();
        this.food = food;
        foodIdx = 0;
        currRow = 0;
        currCol = 0;
        score = 0;
        snake.offer(new int[] {currRow, currCol});
    }
    
    public int move(String direction) {
        int nr = currRow;
        int nc = currCol;
        switch(direction) {
            case "U": {
                nr = nr - 1;
                break;
            }
            case "D": {
                nr = nr + 1;
                break;
            }
            case "L": {
                nc = nc - 1;
                break;
            }
            case "R": {
                nc = nc + 1;
                break;
            }
            default: {
                System.out.println("Wrong move: " + direction);
                return -1;
            }
        }
        
        // checking boundry hit
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
            return -1;
        } 

       

        // check new position has food: order 1
       boolean eatsFood = foodIdx < food.length && food[foodIdx][0] == nr && food[foodIdx][1] == nc;
       if (!eatsFood) {
            snake.poll();
       } else {
            this.foodIdx++;
            this.score++;
       }

        // check snake hit itself: order2: order matters since food not present then tails should be removed first and then move.
        for (int[] pos: snake) {
            if (pos[0] == nr && pos[1] == nc) {
                return -1;
            }
        }

        currRow = nr;
        currCol = nc;
        snake.offer(new int[] {nr, nc});
        return this.score;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
