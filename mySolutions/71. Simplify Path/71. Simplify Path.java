class Solution {
    public int lengthLongestPath(String input) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;
        String[] lines = input.split("\n");
        for (int i = 0; i < lines.length; i++) {
            // dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext
            String line = lines[i];
            int tapCount = line.lastIndexOf("\t") + 1;

            while (tapCount < stack.size()) {
                stack.pop();
            }
            int pathLength = (stack.isEmpty() ? 0 : stack.peek()) + line.length() - tapCount;
            // System.out.printf("line: %s, tapCount: %d, pathLength: %d\n", line, tapCount,
            // pathLength);
            stack.push(pathLength + "/".length());

            if (line.indexOf(".") != -1) {
                max = Math.max(pathLength, max);
            }
        }
        return max;
    }
}