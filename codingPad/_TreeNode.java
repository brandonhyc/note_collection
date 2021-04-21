
package codingPad;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _TreeNode {
	_TreeNode left;
	_TreeNode right;
	Integer key;
	int hidden;

	_TreeNode() {
	}

	_TreeNode(int rootVal) {
		this.key = rootVal;
	}

	_TreeNode(_TreeNode left, _TreeNode right) {
		this.left = left;
		this.right = right;
	}

	_TreeNode(int rootVal, int leftVal, int rightVal) {
		this.key = rootVal;
		this.left = new _TreeNode(leftVal);
		this.right = new _TreeNode(rightVal);
	}

	_TreeNode(Integer[] keys) {
		if (keys == null || keys.length == 0) {
			this.key = -1;
			return;
		}
		_TreeNode[] trees = new _TreeNode[keys.length];
		trees[0] = this;
		this.key = keys[0];
		constructFromArray(0, trees, keys);

	}

	_TreeNode(int[] keys) {
		if (keys == null || keys.length == 0) {
			this.key = -1;
			return;
		}

		Integer[] array = new Integer[keys.length];
		for (int i = 0; i < keys.length; i++) {
			array[i] = Integer.valueOf(keys[i]);
		}

		_TreeNode[] trees = new _TreeNode[keys.length];
		trees[0] = this;
		this.key = keys[0];
		constructFromArray(0, trees, array);
	}

	public _TreeNode getChild(int key) {
		return _getChild(this, key);
	}

	private _TreeNode _getChild(_TreeNode root, int key) {
		if (root == null || root.key == key) {
			return root;
		}
		_TreeNode left = _getChild(root.left, key);
		_TreeNode right = _getChild(root.right, key);

		return (left != null) ? left : right;
	}

	private _TreeNode constructFromArray(int i, _TreeNode[] trees, Integer[] keys) {

		_TreeNode root = i != 0 ? new _TreeNode(keys[i]) : trees[i];
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
		if (key == null) {
			return "null";
		}

		_TreeNode curr = this;
		StringBuilder sb = new StringBuilder();
		Queue<_TreeNode> queue = new LinkedList<>();
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
					sb.append(curr.key + padding);
					queue.offer(curr.left);
					queue.offer(curr.right);
				}
			}

		}

		return sb.toString();
	}

//	-------------------------- helper functions

	static public _TreeNode getLCA(_TreeNode root, List<_TreeNode> nodes) {
		Set<_TreeNode> candidates = new HashSet<>(nodes);
		_TreeNode[] res = new _TreeNode[1];

		_getLCA(root, candidates, res, nodes.size());
		return res[0];
	}

	// return the candidates found so far
	static private int _getLCA(_TreeNode root, Set<_TreeNode> set, _TreeNode[] res, int total) {
		if (root == null) {
			return 0;
		}

		int left = _getLCA(root.left, set, res, total);
		int right = _getLCA(root.right, set, res, total);
		int curr = left + right;

		if (set.contains(root)) {
			curr++;
		}
		if (curr == total) {
			res[0] = root;
			return 0;
		}

		return curr;
	}
	
	static _TreeNode getSampleTree0() {
		_TreeNode root = new _TreeNode(1);
		root.left = new _TreeNode(2);
		root.right = new _TreeNode(3);

		root.left.left = new _TreeNode(4);
		root.left.right = new _TreeNode(5);

		root.right.left = new _TreeNode(6);
		root.right.right = new _TreeNode(7);

		root.left.left.left = new _TreeNode(8);
		root.left.left.right = new _TreeNode(9);

		root.left.right.left = new _TreeNode(10);
		root.left.right.right = new _TreeNode(11);

		root.right.left.left = new _TreeNode(12);

		return root;
	}

	static class BSTIterator implements Iterator<_TreeNode> {
		Deque<_TreeNode> stack;
		_TreeNode helper;

		public BSTIterator(_TreeNode root) {
			stack = new ArrayDeque<>();
			helper = root;
		}

		public boolean hasNext() {
			return !stack.isEmpty() || helper != null;
		}

		public _TreeNode next() {
			while (!stack.isEmpty() || helper != null) {
				if (helper == null) {
					helper = stack.pollFirst();
					_TreeNode res = helper;
					helper = helper.right;
					return res;
				} else {
					stack.offerFirst(helper);
					helper = helper.left;
				}
			}

			return null;
		}
	}

}
