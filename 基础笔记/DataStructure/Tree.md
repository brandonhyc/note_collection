
#Tree 

## BST
The most common type of tree all `nodes in left child` < `root` < `nodes in right child`. This is the most significant feature of `BST`. Utilize this feature to perfomance any search  

## Common traverse    
```
    1
   / \
  2   3
 / \
4   5

(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1
(d) Levelorder (each level): 1 2 3 4 5 x x

```

### inorder traverse
The fact that the order of inorder is `leftEnd -> root -> rightEnd`, we realize this is the same order of traversing `BST` from `Minimum to Maximum`. It can be used as a common solution for `BST`.

.94.  Binary Tree Inorder Traversal
.173. Binary Search Tree Iterator
.95.  Unique Binary Search Trees II
.98.  Validate Binary Search Tree
.285. Inorder Successor in BST  `Successor` + `BST`


### preorder traverse
`root -> leftEnd -> (root) -> rightEnd` from this order, we realize it takes a step back to root. That's quite like the mechanism of `Stack`. So `Stack` is commonly used in iterative traversing preorder.
This order is very much the path of `DFS` aka `Root -> Leaf`.

.114. Flatten Binary Tree to Linked List
.257. Binary Tree Paths == .129. Sum Root to Leaf Numbers 简单，可以不做

### levelorder traverse
.116. Populating Next Right Pointers in Each Node
.117. Populating Next Right Pointers in Each Node II -- Dummy Node

### Height
.110. Balanced Binary Tree

### Successor/predecessor 
Successor means the next larger node. To solve this kind of questions, some conditions are essentially helpful to use:
1. the tree is `BST`
2. A successor can only be: a. the smallest node on the right; b. its parent.     
3. Store a `prev` node to record its parent. See case:
```
    5
   / \
  3   6
 / \
2   4

Successor of 4 is 5, so set prev = cur for searching in cur.val > target.val
```