class SnakeGame {
    
    Snake snake = new Snake();
    Queue<int[]> foods = new LinkedList<>();
    int width = 0;
    int height = 0;
    
    Map<String, int[]> directions = new HashMap<String, int[]>() {{
        put("U", new int[]{-1, 0});
        put("L", new int[]{0, -1});
        put("R", new int[]{0, 1});
        put("D", new int[]{1, 0});
    }};
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        foods = new LinkedList<>();
        snake = new Snake();
        this.height = height;
        this.width = width;
        
        // add food
        for (int i = 0; i < food.length; i++) {
            foods.offer(food[i]);
        }
        snake.px.offer(0);
        snake.py.offer(0);
        
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int dx = directions.get(direction)[1];
        int dy = directions.get(direction)[0];
        
        int nx = snake.px.peekLast() + dx;
        int ny = snake.py.peekLast() + dy;
        
        if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
            return -1;
        }
        
        snake.px.offer(nx);
        snake.py.offer(ny);
        
        if (this.foods.size() != 0 && this.foods.peek()[1] == nx && this.foods.peek()[0] == ny) {
            // System.out.printf("ate food\n");
            this.foods.poll();
        } else {
            snake.px.poll();
            snake.py.poll();
        }
        
        // check if it has collision after moved
        for (int i = 0; i < snake.px.size() - 1; i++) {
            int lx = snake.px.poll();
            int ly = snake.py.poll();
            
            if (lx == nx && ly == ny) {
                // System.out.printf("lx: %d, ly: %d, nx: %d, ny: %d\n", lx, ly, nx, ny);
                // System.out.printf("px: %s, \npy: %s\n", snake.px.toString(), snake.py.toString());
                return -1;
            }
            
            snake.px.offer(lx);
            snake.py.offer(ly);
        }
        
        snake.px.offer(snake.px.poll());
        snake.py.offer(snake.py.poll());
        
        // System.out.printf("after going %s\n", direction);
        // System.out.printf("x: %s\ny:%s\n", snake.px.toString(), snake.py.toString());
        return this.snake.px.size() - 1;
    }
    
    class Snake {
        int length = 0;
        Deque<Integer> px = new LinkedList<>();
        Deque<Integer> py = new LinkedList<>();
        
        public Snake() {
            int length = 0;
            px = new LinkedList<>();
            py = new LinkedList<>();
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */