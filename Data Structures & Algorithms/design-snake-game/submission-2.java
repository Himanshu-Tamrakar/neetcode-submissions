
/**
 * SnakeGame: A classic snake game simulation on a grid.
 * 
 * The snake starts at position (0, 0) with length 1.
 * Each move, the snake's head moves in the given direction.
 * - If the head reaches food, the snake grows and score increases.
 * - If the head goes out of bounds or hits the body, the game ends.
 * - Otherwise, the tail is removed to maintain the snake's length.
 */
class SnakeGame {
    private int rows;           // Height of the game board
    private int cols;           // Width of the game board
    private Queue<int[]> snake; // Queue storing snake body positions [row, col]
    private int[][] food;       // Array of food positions
    private int currRow;        // Current head row position
    private int currCol;        // Current head column position
    private int score;          // Current game score (snake length - 1)
    private int foodIdx;        // Index of the next food to be consumed

    public SnakeGame(int width, int height, int[][] food) {
        rows = height;
        cols = width;
        snake = new LinkedList<>();
        this.food = food;
        foodIdx = 0;
        currRow = 0;
        currCol = 0;
        score = 0;
        snake.offer(new int[] {currRow, currCol}); // Initialize snake at (0, 0)
    }
    
    public int move(String direction) {
        // Calculate the new head position
        int nr = currRow;
        int nc = currCol;
        
        switch(direction) {
            case "U": 
                nr--;  
                break;
            case "D": 
                nr++;  
                break;
            case "L": 
                nc--;  
                break;
            case "R": 
                nc++;  
                break;
            default: 
                System.out.println("Wrong move: " + direction);
                return -1;
        }
        
        // Check if the new head position is out of bounds
        // Game over if head hits the wall
        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
            return -1;
        } 
        
        // Check if there is food at the new position
        // IMPORTANT: This check must be done BEFORE checking collision
        boolean eatsFood = foodIdx < food.length && 
                           food[foodIdx][0] == nr && 
                           food[foodIdx][1] == nc;
        
        // Update snake body: either grow (if food) or move (remove tail)
        if (!eatsFood) {
            // No food: remove the tail
            snake.poll();
        } else {
            // Food found: keep the tail
            this.foodIdx++;
            this.score++;
        }

        // Check if the new head collides with the snake's body
        // IMPORTANT: This check MUST be done AFTER removing the tail
        // because moving into the current tail position is legal if no food is eaten
        for (int[] pos : snake) {
            if (pos[0] == nr && pos[1] == nc) {
                return -1;  // Game over: snake hits itself
            }
        }

        // Move the head to the new position
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
