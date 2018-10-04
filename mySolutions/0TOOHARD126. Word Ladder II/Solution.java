import sun.misc.Queue;

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(
           String start, String end, 
           Set<String> dict) {

        List<List<String>> results = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>()
        bfs(String start, Set<String> dict);
    }

    private  dfs(String end, 
                List<List<String>> results,
                Map<String, List<String>> map, 
                Map<String, Integer> distance,
                List<String> path, String crt){
        if (crt.equals(end)) {
            path.add(end);
            results.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }

        for (String next: map.get(crt)) {
            if (distance.containsKey(next) && 
                distance.get(crt) == distance)
        }
    }

    private void bfs(String start, 
                    Set<String> dict, 
                    Map<String, List<String>> map,
                    Map<String, Integer> distance) {
        
        for (String word: dict) {
            map.put(word, new ArrayList<>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);

        while (!queue.isEmpty()) {
            String crt = queue.poll();
            Set<String> nextList = expand(crt, dict);

            queue.offer(next);
            for (String next: nextList) {
                if (distance.containsKey(next)) {
                    continue;
                }
                distance.put(next, distance.get(crt) + 1);
                map.get(crt).add(next);
            }
        }
    }

    private Set<String> expand(String crt, Set<String> dict) {
        
        Set<String> result = new HashSet<>();
        char[] charArray = crt.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            for (char c = 'a'; c <= 'z'; c++ ) {
                char temp = charArray[i];
                charArray[i] = c;
                String next = new String(charArray);
                if (!dict.contains(next)) {
                    continue;
                }
                result.add(next);
            }
        }
    }
}