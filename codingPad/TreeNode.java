
package codingPad;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode<T> {
	public TreeNode<T> left;
	public TreeNode<T> right;
	public T val;

	TreeNode() {
	}

	TreeNode(T rootVal) {
		this.val = rootVal;
	}

	TreeNode(TreeNode<T> left, TreeNode<T> right) {
		this.left = left;
		this.right = right;
	}


	TreeNode(T[] keys) {
		if (keys == null || keys.length == 0) {
			this.val = null;
			return;
		}
		TreeNode<T>[] trees = new TreeNode[keys.length];
		trees[0] = this;
		this.val = keys[0];
		constructFromArray(0, trees, keys);

	}

	private TreeNode<T> constructFromArray(int i, TreeNode<T>[] trees, T[] keys) {

		TreeNode<T> root = i != 0 ? new TreeNode<T>(keys[i]) : trees[i];
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		trees[i] = root;

		if (l < keys.length && keys[l] != null) {
			trees[l] = constructFromArray(l, trees, keys);
			root.left = trees[l];
		}
		if (r < keys.length && keys[r] != null) {
			trees[r] = constructFromArray(r, trees, keys);
			root.right = trees[r];
		}

		return root;
	}

	@Override
	public String toString() {
		if (val == null) {
			return "null";
		}

		TreeNode<T> curr = this;
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode<T>> queue = new LinkedList<>();
		final String padding = " ";

		queue.offer(curr);
		while (queue.size() != 0) {
			int size = queue.size();
			sb.append("\n");
			for (int i = 0; i < size; i++) {
				curr = queue.poll();
				if (curr == null) {
					sb.append("x" + padding);
				} else {
					sb.append(curr.val + padding);
					queue.offer(curr.left);
					queue.offer(curr.right);
				}
			}

		}

		return sb.toString();
	}

//	-------------------------- helper functions


}
