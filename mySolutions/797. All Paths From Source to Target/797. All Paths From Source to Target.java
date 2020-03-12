class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < graph.length; i++) {
            map.putIfAbsent(i, new ArrayList<>());
            for (Integer to : graph[i]) map.get(i).add(to);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(map, 0, graph.length - 1, res, path);
        return res;
    }
    
    private void dfs(Map<Integer, List<Integer>> map, int from, int des, List<List<Integer>> res, List<Integer> path) {
        if (from == des) res.add(new ArrayList<>(path));
        
        for (int i = 0; i < map.get(from).size(); i++) {
            Integer next = map.get(from).get(i);
            path.add(next);
            dfs(map, next, des, res, path);
            path.remove(path.size() - 1);
        }
        
    }
}