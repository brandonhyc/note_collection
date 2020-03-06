public static void main(String[] args) {
	int[] u = {1,2,3,4,5,3};
	int[] v = {2,3,4,5,1,5};
	int[] w = {9,11,6,1,4,10};
	int start = 1, end = 5;
	int x = 2, y = 3;
	System.out.println(getMinTime(u, v, w, start, end, x, y));
}

static int res = Integer.MAX_VALUE;

private static int getMinTime(int[] u, int[] v, int[] w, int start, int end, int x, int y) {
	Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
	for(int i=1;i<=u.length;i++)
		map.put(i, new HashMap<>());
	for(int i=0;i<u.length;i++) {
		map.get(u[i]).put(v[i], w[i]);
		map.get(v[i]).put(u[i], w[i]);
	}
	boolean[] visited = new boolean[u.length+1];
	dfs(map, visited, start, end, x, y, 0);
	return res;
}

private static void dfs(Map<Integer, Map<Integer, Integer>> map, boolean[] visited, int cur, int end, int x, int y, int tmp) {
	if(tmp > res)
		return;
	if(visited[x] && visited[y] && cur == end) {
		res = Math.min(res, tmp);
		return;
	}
	visited[cur] = true;
	for(Map.Entry<Integer, Integer> nei : map.get(cur).entrySet()) {
		if(!visited[nei.getKey()]) {
			dfs(map, visited, nei.getKey(), end, x, y, tmp + map.get(cur).get(nei.getKey()));
		}
	}
	visited[cur] = false;
}


------------------------------------------------------
    public static void main(String[] args) {
        Main obj = new Main();
        int[] u = {1,2,3,4,5,3};
	    int[] v = {2,3,4,5,1,5};
	    int[] w = {9,11,6,1,4,10};
	    int start = 1, end = 5;
	    int x = 2, y = 3;
        System.out.println(obj.getMinTime(u, v, w, start, end, x, y));
    }
    
    private int getMinTime(int[] u, int[] v, int[] w, int start, int end, int x, int y) {
        int n = u.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i=0; i<n; ++i) {
            map.putIfAbsent(u[i], new HashMap<>());
            map.putIfAbsent(v[i], new HashMap<>());
            map.get(u[i]).put(v[i], w[i]);
            map.get(v[i]).put(u[i], w[i]);
        }
        int result = findShortestPath(map, x, y);
        result += Math.min(findShortestPath(map, start, x) + findShortestPath(map, y, end),
                          findShortestPath(map, start, y) + findShortestPath(map, x, end));
        return result;
    }
    
    private int findShortestPath(Map<Integer, Map<Integer, Integer>> map, int start, int end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        queue.offer(new int[]{start, 0});
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            if(info[0] == end) return info[1];
            Map<Integer, Integer> edges = map.get(info[0]);
            if(edges != null) {
                for(Map.Entry<Integer, Integer> e : edges.entrySet()) {
                    queue.offer(new int[]{e.getKey(), e.getValue() + info[1]});
                }
            }
        }
        return 0;
    }