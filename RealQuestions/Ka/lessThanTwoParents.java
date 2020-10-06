public List<Integer> findAll(int[][] input) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Map<Integer, Integer> indegree = new HashMap<>();
    for (int[] pair : input) {
        if(!map.containsKey(pair[0])) {
            map.put(pair[0], new ArrayList<>());
        }
        map.get(pair[0]).add(pair[1]);
        indegree.put(pair[1], indegree.getOrDefault(pair[0], 0) + 1);
    }
    List<Integer> list = new ArrayList<>();
    for (Map.Entry<Integer, List<Integer>> en : indegree.entrySet()) {
        if (en.getValue() <= 1) {
            list.add(en.getKey());
        }
    }
    return list;
} 