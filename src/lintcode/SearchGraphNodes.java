package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class SearchGraphNodes {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        if (node == null || graph.size() == 0) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        Map<UndirectedGraphNode, Integer> visited = new HashMap<UndirectedGraphNode, Integer>();
        while (!queue.isEmpty()) {
            UndirectedGraphNode newNode = queue.poll();
            if (visited.containsKey(newNode)) {
                continue;
            }
            if (values.get(newNode) == target) {
                return newNode;
            }
            visited.put(newNode, 1);
            if (!newNode.neighbors.isEmpty()) {
                for (int i = 0; i < newNode.neighbors.size(); i++) {
                    queue.add(newNode.neighbors.get(i));
                }
            }
        }
        return null;
    }
}
