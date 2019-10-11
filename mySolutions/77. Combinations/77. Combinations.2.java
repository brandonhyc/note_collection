class Solution {
    public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combine(n, k, combs, new ArrayList<>(), 0);
		return combs;
	}
	public static void combine(int n, int k, List<List<Integer>> combs, List<Integer> comb, int start) {
		if(k == 0) {
			combs.add(new ArrayList<Integer>(comb));
			return;
		}
		for(int i = start; i < n; i++) {
			comb.add(i + 1);
			combine(n, k - 1, combs, comb, i + 1);
			comb.remove(comb.size() - 1);
		}
	}
}