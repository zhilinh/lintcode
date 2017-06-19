package lintcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();        
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode root = queue.poll();
            if (visited.containsKey(root)) {
                continue;
            }
            UndirectedGraphNode cloneRoot = new UndirectedGraphNode(root.label);
            map.put(root, cloneRoot);
            visited.put(root, true);
            for (int i = 0; i < root.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = root.neighbors.get(i);
                if (!visited.containsKey(neighbor)) {
                    UndirectedGraphNode cloneNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, cloneNeighbor);
                    queue.offer(neighbor);
                }
            }
        }
        visited = new HashMap<UndirectedGraphNode, Boolean>();
        queue.offer(node);        
        while (!queue.isEmpty()) {
            UndirectedGraphNode root = queue.poll();
            if (visited.containsKey(root)) {
                continue;
            }
            visited.put(root, true);
            for (int i = 0; i < root.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = root.neighbors.get(i);
                map.get(root).neighbors.add(map.get(neighbor));
                if (!visited.containsKey(neighbor)) {
                    queue.offer(neighbor);
                }
            }            
        }
        return map.get(node);
    }
}