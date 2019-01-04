public class Solution {
    /**
     * @param setList: The input set list
     * @return: the cartesian product of the set list
     */
    public List<List<Integer>> getSet(int[][] setList) {
        // Write your code here

        if (setList == null || setList.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        if (setList[0] == null || setList[0].length == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<>();

        dfs(results, setList, new ArrayList<Integer>(), 0);
        return results;
    }

    private void dfs(List<List<Integer>> results, 
                    int[][] setList,
                    List<Integer> combination,
                    int setIndex) {
        if (setList.length == combination.size()) {
            List<Integer> resultCopy = new ArrayList<>(combination);
            results.add(resultCopy);
            return;
        }

        for (int i = 0; i < setList[setIndex].length; i++) {
            combination.add(setList[setIndex][i]);
            dfs(results, setList, combination, setIndex + 1);

            int size = combination.size();
            combination.remove(size - 1);
        }
    }
}