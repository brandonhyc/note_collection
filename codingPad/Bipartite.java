package codingPad;

import java.util.HashSet;
import java.util.Set;

class Bipartite {
    public boolean isBipartite(int[][] graph) {


        // traverse the whole graph, for each node
        //       depth first search, from this node, for each neighbor
        //             if visit, check the color
        Set<Integer> visited = new HashSet<>();
        int color = 0;

        for (int i = 0; i < graph.length; i++) {
            if (!visited.contains(i) && dfsMark(i, graph, visited)) {
                color++;
            }
        }

        return color >= 2;
    }

    private boolean dfsMark(int id, int[][] graph, Set<Integer> visited) {
        if (visited.add(id)) {
            return false;
        }

        for (int j = 0; j < graph[id].length; j++) {
            dfsMark(graph[id][j], graph, visited);
        }

        return true;
    }

}

