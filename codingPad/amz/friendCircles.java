package codingPad.amz;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class friendCircles {

    public static int friendCircles(List<List<Integer>> relationships) {

        int cirCount = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < relationships.size(); i++) {
            if (visited.add(i)) {
                search(i, relationships, visited);
                cirCount++;
            }

        }

        return cirCount;
    }

    private static void search(int id, List<List<Integer>> relShs, Set<Integer> visited) {

        for (int i = 0; i < relShs.get(id).size(); i++) {
            if (relShs.get(id).get(i) == 1 && visited.add(i)) {
                search(i, relShs, visited);
            }
        }
    }


}
