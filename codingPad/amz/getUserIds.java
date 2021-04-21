package codingPad.amz;

import java.util.*;

public class getUserIds {
    public static List<String> getUserIds(List<String> logs, int threshold) {
        Map<String, Integer> count = new HashMap<>(); // key: UserId, value: frequence
        for (String log : logs) {
            String[] tuple = log.split(" ");
            count.putIfAbsent(tuple[0], 0);
            count.putIfAbsent(tuple[1], 0);

            count.put(tuple[0], count.get(tuple[0]) + 1);
            if (!tuple[0].equals(tuple[1])) {
                count.put(tuple[1], count.get(tuple[1]) + 1);
            }
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> en : count.entrySet()) {
            if (en.getValue() >= threshold) {
                res.add(en.getKey());
            }
        }
        Collections.sort(res);

        return res;
    }


}
