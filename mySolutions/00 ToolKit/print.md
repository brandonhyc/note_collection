# Print Map
Arrays.toString(map.entrySet().toArray());

# init Map
HashMap<String, String> h = new HashMap<String, String>() {{
    put("a","b");
}};

# Print Matrix
int[][] array = new int[rows][columns];
System.out.println(Arrays.deepToString(array));


https://stackoverflow.com/questions/7384791/splitting-strings-through-regular-expressions-by-punctuation-and-whitespace-etc
# remove punctuation
1.
String[] Res = Text.split("[\\p{Punct}\\s]+");
2.
String line = "Hello! this is a line. It can't be hard to split into \"words\", can it?";
String[] words = line.split("\\W+");
3.
String[] Res = Text.split("\\P{L}+");


# Print Tree
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

# Print TreeNode in Queue
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