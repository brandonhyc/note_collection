class Solution {
    public String simplifyPath(String path) {
        // "/a/./b/../../c/"
        // "/a/../../b/../c//.//"
        Stack<String> stack = new Stack<>();
        int leftSlash = 0;
        while (leftSlash < path.length()) {
            int rightSlash = leftSlash + 1;
            while (rightSlash < path.length() && path.charAt(rightSlash) != '/') {
                rightSlash++;
            }
            String clip = path.substring(leftSlash + 1, rightSlash);
            if (clip.length() == 0 || clip.equals(".")) {
                // doing nothing
            } else if (clip.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // normal
                stack.push(clip);
            }
            leftSlash = rightSlash;
        }

        Collections.reverse(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pop());

        }
        return sb.length() != 0 ? sb.toString() : "/";
    }
}