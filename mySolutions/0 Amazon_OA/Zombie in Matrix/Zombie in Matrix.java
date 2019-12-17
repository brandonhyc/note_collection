
import java.util.*;

public class HelloWorld {

    public static void main(String[] args) {
        List<List<Integer>> matrix1 = new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(0, 1, 1, 0, 1));
                add(Arrays.asList(0, 1, 0, 1, 0));
                add(Arrays.asList(0, 0, 0, 0, 1));
                add(Arrays.asList(0, 1, 0, 0, 0));
            }
        };
        System.out.printf("result: %d\n", minHours(matrix1));

        List<List<Integer>> matrix2 = new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(0, 0));
            }
        };
        System.out.printf("result: %d\n", minHours(matrix2));

        List<List<Integer>> matrix3 = new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(1, 1));
            }
        };
        System.out.printf("result: %d\n", minHours(matrix3));

        List<List<Integer>> matrix4 = new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(1, 0, 0));
                add(Arrays.asList(0, 0, 0));
                add(Arrays.asList(0, 0, 0));
            }
        };
        System.out.printf("result: %d\n", minHours(matrix4));

    }

    private static final int ZOMBIE = 1;
    private static final int HUMAN = 0;
    private static final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    static public int minHours(List<List<Integer>> grid) {
        Queue<int[]> zombies = new LinkedList<>();
        int hours = 0;
        int humanCount = 0;
        int zombieCount = 0;

        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid.get(0).size(); x++) {
                if (grid.get(y).get(x) == ZOMBIE) {
                    zombieCount += 1;
                    zombies.offer(new int[] { y, x });
                }
                if (grid.get(y).get(x) == HUMAN) {
                    humanCount += 1;
                }
            }
        }

        if (humanCount == 0) {
            return 0;
        }

        while (zombies.size() != 0) {
            int size = zombies.size();
            hours += 1;

            for (int i = 0; i < size; i++) {
                int[] pos = zombies.poll();

                for (int j = 0; j < DIRS.length; j++) {
                    int nx = pos[1] + DIRS[j][1];
                    int ny = pos[0] + DIRS[j][0];

                    // out of boundary
                    if (nx < 0 || nx >= grid.get(0).size() || ny < 0 || ny >= grid.size()) {
                        continue;
                    }

                    // human become zombie
                    if (grid.get(ny).get(nx) == HUMAN) {
                        humanCount -= 1;
                        zombieCount += 1;
                        grid.get(ny).set(nx, ZOMBIE);
                        zombies.add(new int[] { ny, nx });
                    }
                }
            }

            if (humanCount == 0) {
                return hours;
            }
        }

        return -1;
    }

}