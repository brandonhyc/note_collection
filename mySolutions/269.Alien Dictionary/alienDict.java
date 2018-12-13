public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        // Write your code here
        Map<Character, Set<Character>> graph = constructGraph(words);
        return topologicalSortring(graph);
    }
    
    private Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                Character charC = new Character(c);
                if (!graph.containsKey(charC)) {
                    graph.put(charC, new HashSet<Character>());
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            int index = 0;
            while (index < words[i].length() && 
                    index < words[i + 1].length()) {
                
                if (words[i].charAt(index) != words[i + 1].charAt(index)) {
                    
                    graph.get(words[i].charAt(index))
                        .add(words[i + 1].charAt(index));
                    break;
                }
                index++;
            }
        }
        return graph;
    }

    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character u : graph.keySet()) {
            indegree.put(u, 0);
        }

        for (Character u : graph.keySet()) {
            for (Character v : graph.get(u)) {
                indegree.put(v, indegree.get(v) + 1);
            }
        }

        return indegree;
    }

    private String topologicalSortring(Map<Character, Set<Character>>graph) {
        Map<Character, Integer> indegree = getIndegree(graph);

        Queue<Character> queue = new PriorityQueue<>();

        for (Character u : indegree.keySet()) {
            if (indegree.get(u) == 0) {
                queue.offer(u);
            }
        }
        
        StringBuilder stringBuilder = new StringBuilder();

        while (!queue.isEmpty()) {
            Character head = queue.poll();
            stringBuilder.append(head);
            
            for (Character neighbor : graph.get(head)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (stringBuilder.length() != indegree.size()) {
            return "";
        }
        return stringBuilder.toString();
    }

}