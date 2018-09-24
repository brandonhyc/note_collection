````java
    private void printTreeNodeinQueue(Queue<TreeNode> que) {
        System.out.println("The tree queue is: ");
        System.out.print("[");
        for (Object node: que) {
            System.out.printf("%d ", ((TreeNode) node).val);
        }
        System.out.println("]");
    }
````