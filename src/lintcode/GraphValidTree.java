package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphValidTree {
    private class Node {
        public int n;
        public boolean visited = false;
        public List<Node> next = new ArrayList<Node>();
        public Node(int x) {
            n = x;
        }
    }
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (n <= 0 || edges == null || (edges.length == 0 && n > 1)) {
            return false;
        }
        Node[] nodes = new Node[n];
        int num = edges.length;
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < num; i++) {
            nodes[edges[i][0]].next.add(nodes[edges[i][1]]);
            nodes[edges[i][1]].next.add(nodes[edges[i][0]]);
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(nodes[0]);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.visited) {
                return false;
            } else {
                node.visited = true;
            }
            for (int i = 0; i < node.next.size(); i++) {
                Node nextNode = node.next.get(i); 
                if (!nextNode.visited) {
                    queue.offer(nextNode);
                    nextNode.next.remove(node);
                } else {
                    return false;
                }
            }
            node.next = new ArrayList<Node>();
        }
        for (int i = 0; i < n; i++) {
            if (!nodes[i].visited) {
                return false;
            }
        }
        return true;
    }
}
