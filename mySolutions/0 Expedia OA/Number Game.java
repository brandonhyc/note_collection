// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(numChange(8));
    }
    
    static private int numChange(int num) {
        String str = Integer.toBinaryString(num);
        String target = new String(new char[str.length()]).replace("\0", "0");
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        visited.add(str);
        queue.offer(str);
        int steps = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            steps += 1;
            for (int i = 0; i < size; i++) {
                String state = queue.poll();
                List<String> states = next(state);
                // if change i, i+1 = 1, all i + 2... are 0
                for (int j = 0; j < states.size(); j++) {
                    String can = states.get(j);
                    if (can.equals(target)) return steps;
                    if (visited.contains(can)) continue;
                    visited.add(can);
                    queue.offer(can);
                }
            }
        }
        return -1;
    }
    
    static private List<String> next(String state) {
        System.out.printf("prev state: %s\n", state);
        List<String> res = new ArrayList<>();
        int i1 = 0;
        for (int i = 1; i < state.length(); i++) {
            if (state.charAt(i) == '1') i1 = i;
        }
        char[] chars = state.toCharArray();
        if (i1 - 1 >= 0) { // add mid option
            chars[i1 - 1] = chars[i1 - 1] == '0' ? '1' : '0';
            res.add(new String(chars));
            chars[i1 - 1] = chars[i1 - 1] == '0' ? '1' : '0';
        }
        // add last-pos option
        chars[state.length() - 1] = chars[state.length() - 1] == '0' ? '1' : '0';
        res.add(new String(chars));
        return res;
    }
    
    
}