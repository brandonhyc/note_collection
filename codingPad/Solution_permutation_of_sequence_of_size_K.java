package codingPad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_permutation_of_sequence_of_size_K {

	// height: N levels for N chars, each level represents what's the character we
	// choose to put at position index of i
	// N to 1 states (branches) spilt from each node (dynamically changing)
	// _ , abc
	// index 0 a b c
	// / \ / \ / \
	// 1 ab ac ba bc ca cb
	// / / / / / \
	// 2 abc acb bac bca cab cba

	public List<String> allPermutationsOfSubsets(String set, int k) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return new ArrayList<>();
		}
		char[] array = set.toCharArray();
		Arrays.sort(array);
		int index = 0;
		helper(array, k, index, res);
		return res;
	}

	private void helper(char[] array, int k, int index, List<String> res) {
		if (index == k) {
			res.add(new String(array, 0, index));
			return;
		}

		for (int i = index; i < array.length; i++) {
			if (i != index && array[i] == array[i - 1]) {
				continue;
			}
			swap(array, index, i);
			helper(array, k, index + 1, res);
			swap(array, index, i);
		}
	}

	private void swap(char[] array, int l, int j) {
		char ch = array[l];
		array[l] = array[j];
		array[j] = ch;
	}
}
