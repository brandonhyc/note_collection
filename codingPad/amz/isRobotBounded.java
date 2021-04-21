package codingPad.amz;

public class isRobotBounded {
    class Solution {
        public boolean isRobotBounded(String movements) {

            final int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            final char G = 'S', L = 'L', R = 'R';

            int facing = 0;
            int[] curr = new int[2];
            for (char op : movements.toCharArray()) {
                if (op == G) {
                    curr[0] = dir[facing][0] + curr[0];
                    curr[1] = dir[facing][1] + curr[1];
                } else if (op == L) {
                    facing = facing != 0 ? facing - 1 : dir.length - 1;
                } else if (op == R) {
                    facing = facing != dir.length - 1 ? facing + 1 : 0;
                }
            }

            return curr[0] == 0 && curr[1] == 0 || facing != 0;
        }

    }
}
