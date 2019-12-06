// https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/7nAKN0Qz67r

class ArrayJump {

    public int countMinJumps(int[] jumps) {

        return count_rec(jumps, 0);
    }

    private int count_rec(int[] jumps, int start) {
        // return minJumps to reach the end

        if (start >= jumps.length) {
            return Integer.MAX_VALUE;
        }

        if (start == jumps.length - 1) {
            return 0;
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= jumps[start]; i++) {
            int steps = count_rec(jumps, i + start);
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