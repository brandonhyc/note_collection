package codingPad;

import java.util.*;
class SnakeGame {


    Map<String, int[]> DIRS = new HashMap<String, int[]>() {{
        put("L", new int[]{ 0, -1 });
        put("R", new int[]{ 0, 1});
        put("U", new int[]{ -1, 0});
        put("D", new int[]{ 1, 0});
    }};
    int leftBound = -1;
    int rightBound = -1;
    int upBound = -1;
    int downBound = -1;
    Queue<Point> food;
    Set<Point> bodySet;
    Queue<Point> bodyQ;
    Point head;

    public SnakeGame(int width, int height, int[][] food) {
        leftBound = 0;
        rightBound = width - 1;
        upBound = 0;
        downBound = height - 1;

        this.food = new LinkedList<Point>();
        for (int i = 0; i < food.length; i++) {
            this.food.offer(new Point(food[i][0], food[i][1]));
        }
        head = new Point(0, 0);
        bodySet = new HashSet<>();
        bodyQ = new LinkedList<>();

        bodySet.add(head);
        bodyQ.offer(head);
    }

//    / Moves the snake.
//     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
//     @return The game's score after the move. Return -1 if game over.
//     Game over when snake crosses the screen boundary or bites its body. /
    public int move(String direction) {

        // move the head
        int cx = head.x, cy = head.y;
        int nx = cx + DIRS.get(direction)[0], ny = cy + DIRS.get(direction)[1];

        Queue<Point> debugQ = bodyQ;
        Queue<Point> foodQ = food;
        Set<Point> debugBody = bodySet;
        Point debugHead = head;

        if (validBound(nx, ny)) {
            if (!food.isEmpty() && (food.peek().x == nx && food.peek().y == ny)) {
                food.poll();
            } else {
                Point tail = bodyQ.poll();
                bodySet.remove(tail);
            }


            Point np = new Point(nx, ny);
            if (validBody(np)) {
                bodySet.add(np);
                bodyQ.offer(np);
                head = np;
                return bodyQ.size() - 1;
            }
        }

        return -1;
    }

    private boolean validBody(Point p) {
        return !bodySet.contains(p);
    }

    private boolean validBound(int x, int y) {
        // not hiting the wall
        return x >= upBound && x <= downBound && y >= leftBound && y <= rightBound;
    }

    private class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Point point = (Point) o;
            return point.x == this.x && point.y == this.y;
        }

        @Override
        public int hashCode() {
            return x + y;
        }

        @Override
        public String toString() {
            return "( "+ x + ", " + y + ")";
        }
    }
}

