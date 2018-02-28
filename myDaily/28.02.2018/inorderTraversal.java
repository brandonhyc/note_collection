    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        //the second time
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
    
        if (root == null) {
            return list;
        }
    
        TreeNode curt = root;
        while (curt != null || !stack.empty()) {
            while (curt != null) {
                System.out.printf("we are reading:%d\n", curt.val);
                stack.add(curt);
                curt = curt.left;

            }
            curt = stack.pop();
            list.add(curt.val);
            curt = curt.right;
        }
        return list;
    }


    // Stack<TreeNode> stack = new Stack<>();
    // ArrayList<Integer> list = new ArrayList<>();

    // if (root == null) {
    //     return list;
    // }

    // TreeNode curt = root;
    // while (!stack.empty()) {
    //     while ( curt != null) {
    //         stack.add(curt);
    //         curt = curt.left;
    //     }
    //     curt = stack.pop();
    //     list.add(curt.val);
    //     curt = curt.right;
    // }
    // return list;