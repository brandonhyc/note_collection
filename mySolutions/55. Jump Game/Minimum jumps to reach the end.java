// https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/7nAKN0Qz67r


class ArrayJump {

    public int countMinJumps(int[] jumps) {
        if (jumps.length == 0) {
            return 0;
        }

        int curSteps = 0;
        int maxIndex = 0;

        for (int i = 0; i < jumps.length; i++) {
            if (maxIndex >= jumps.length - 1) {
                return curSteps;
            }

            maxIndex += jumps[i];
            curSteps += 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] jumps = { 2, 1, 1, 1, 4 };
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[] { 1, 1, 3, 6, 9, 3, 0, 1, 3 };
        System.out.println(aj.countMinJumps(jumps));
    }
}

class ArrayJump {

    public int countMinJumps(int[] jumps) {
        if (jumps.length == 0) {
            return 0;
        }

        int[] dp = new int[jumps.length];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 1; j <= jumps[i]; j++) {
                // pick the possible minimum move
                if (i + j <= jumps.length - 1) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }

        return (dp[jumps.length - 1] == Integer.MAX_VALUE) ? -1 : dp[jumps.length - 1];
    }

    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] jumps = { 2, 1, 1, 1, 4 };
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[] { 1, 1, 3, 6, 9, 3, 0, 1, 3 };
        System.out.println(aj.countMinJumps(jumps));
    }
}


class ArrayJump {

    public int countMinJumps(int[] jumps) {
        if (jumps.length == 0) {
            return 0;
        }
        int[] dp = new int[jumps.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        return count_rec(jumps, 0, dp);
    }

    private int count_rec(int[] jumps, int start, int[] dp) {
        // return minJumps to reach the end

        if (start >= jumps.length) {
            return Integer.MAX_VALUE;
        }

        if (start == jumps.length - 1) {
            return 0;
        }

        if (dp[start] != Integer.MAX_VALUE) {
            return dp[start];
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= jumps[start]; i++) {
            int steps = count_rec(jumps, i + start, dp);
            if (steps != Integer.MAX_VALUE) {
                steps += 1;
            }
            minSteps = Math.min(steps, minSteps);
        }
        return minSteps;
    }

    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] jumps = { 2, 1, 1, 1, 4 };
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[] { 1, 1, 3, 6, 9, 3, 0, 1, 3 };
        System.out.println(aj.countMinJumps(jumps));
    }
}