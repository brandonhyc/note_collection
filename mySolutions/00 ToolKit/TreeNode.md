

```java

    private void printTreeNode(TreeNode node) {
        if (node == null) {
            System.out.println("node is null");
        } else {
            System.out.printf("node is %d\n", node.val);
            if (node.left != null) {
                System.out.printf("       %d ", node.left.val);
            } else { System.out.printf("       # "); }
            if (node.right != null) {
                System.out.printf("  %d\n", node.right.val);
            } else { System.out.printf(" #\n");}
        }
    }
```