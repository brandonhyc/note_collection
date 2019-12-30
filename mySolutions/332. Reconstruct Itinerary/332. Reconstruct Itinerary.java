class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        PriorityQueue<String> minheap = new PriorityQueue<>();
        
        Map<String, PriorityQueue> graph = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();
        
        for (List<String> t : tickets) {
            String fm = t.get(0);
            String to = t.get(1);
            graph.putIfAbsent(fm, new PriorityQueue<>());
            
            graph.get(fm).add(to);
        }
        
        dfs("JFK", graph, result);
        
        return result;
    }
    
    private void dfs(String departure, Map<String, PriorityQueue> graph, LinkedList<String> result) {
        
        // result.add(departure);
        PriorityQueue<String> arrivals = graph.get(departure);
        
        while (arrivals != null && arrivals.size() != 0) {
            dfs(arrivals.poll(), graph, result);
        }
        result.add(0, departure);
    }
}