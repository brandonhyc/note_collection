package codingPad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphNode {
	public int key;
	public List<GraphNode> neighbors;

	public GraphNode(int key) {
		this.key = key;
		this.neighbors = new ArrayList<GraphNode>();
	}
	
	@Override
	public String toString() {
		List<Integer> list = new ArrayList<>();
		for (GraphNode neihbor : neighbors) {
			list.add(neihbor.key);
		}
		return "< " + key + ": "+ list + ">";
	}
	
	public List<GraphNode> copy(List<GraphNode> graph) {
		Map<GraphNode, GraphNode> map = copyHelper(graph);
		List<GraphNode> newGraph = convert(map);
		return newGraph;
	}

	private Map<GraphNode, GraphNode> copyHelper(List<GraphNode> graph) {
		Map<GraphNode, GraphNode> map = new HashMap<>(); // <Old, New>

		for (GraphNode node : graph) {
			helper(node, map);
		}
		return map;
	}

	private void helper(GraphNode head, Map<GraphNode, GraphNode> map) {
		if (map.containsKey(head)) {
			return;
		}
		GraphNode clone = new GraphNode(head.key);
		map.put(head, clone);
		for (GraphNode neihbor : head.neighbors) {
			if (!map.containsKey(neihbor)) {
				helper(neihbor, map);
			}
			clone.neighbors.add(map.get(neihbor));
		}
	}

	private List<GraphNode> convert(Map<GraphNode, GraphNode> map) {
		List<GraphNode> res = new ArrayList<>();
		for (Map.Entry<GraphNode, GraphNode> pair : map.entrySet()) {
			res.add(pair.getValue());
		}
		return res;
	}

	public static List<GraphNode> build(List<List<Integer>> graphList) { 
		// build graph with List<Head<Neibors>>
		Map<Integer, GraphNode> map = new HashMap<>();
		
		for (int i = 0; i < graphList.size(); i++) { // each head
			if (!map.containsKey(i)) {
				map.put(i, new GraphNode(i));
			}
			GraphNode curr = map.get(i);
			
			for (Integer j : graphList.get(i)) { // each neighbor num
				if (!map.containsKey(j)) {
					map.put(j, new GraphNode(j));
				}
				curr.neighbors.add(map.get(j));
			}
		}
		
		return convert(map.values());
	}

	private static List<GraphNode> convert(Collection<GraphNode> values) {
		List<GraphNode> res = new ArrayList<>();
		for (GraphNode head : values) {
			res.add(head);
		}
		return res;
	}
}