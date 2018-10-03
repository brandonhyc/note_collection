public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

        List<List<String>> results = new ArrayList<>();

        if (start.length() == 0 || end.length() == 0 || dict.size() == 0) {
            return results;
        }

        Map<String, ArrayList> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(start, dict, distance, map);
        dfs(end, results, new ArrayList<>(), distance, map, start);

        return results;

    }

    private void dfs(String end, List<List<String>> results, 
                    List<String> path, Map<String, Integer> distance,
                    Map<String, List<String> map,
                    String crt) {

        if (crt.equals(end)) {
            path.add(crt);
            results.add(new ArrayList<>(path));
            path.remove(crt);
            return;
        }
        ArrayList<String> = map.get(crt);

        for (String next: ) {
            if (!distance.containsKey(next)) {
                continue;
            }
            if (distance.get(crt) != distance.get(next) + 1) {
                continue;
            }
            path.add(crt);
            dfs(start, end, dict, results, path, distance, map, next);
            path.remove(path.size() - 1);

        }
    }

    private void bfs (String start, Set<String> dict, 
                    Map<String, Integer> distance, Map<String, List<String>> map) {
        

        for (String s : dict) {
            map.put(s, new ArrayList<String>());
        }

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);

        distance.put(start, 0);
        
        while(!queue.isEmpty()) {
            
            String crt = queue.poll();
            List<String> nextList = expand(dict, crt);

            for (String word: nextList) {
                map.get(next).add(crt);
                if (!distance.containsKey(word)) {
                    distance.put(word, distance.get(crt) + 1);
                    queue.offer(word);
                }
            }
        }
    }
    private List<String> expand(Set<String> dict, String crt) {
        List<String> result =  new ArrayList<>();
        char[] charArray = crt.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (char c = 'a'; c < 'z'; c++) {
                if (c == charArray[i]) {
                    continue;
                }
                charArray[i] = c;
                String nextWord = new String(charArray);
                if (dict.contains(nextWord)) {
                    result.add(nextWord);
                }
            }
        }
    }
}