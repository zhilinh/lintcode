package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class ZombieInMatrix {
    int m, n;
    private class Index {
        public int x, y;
        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int step = 0;
        m = grid.length;
        n = grid[0].length;
        Queue<Index> queue = new LinkedList<Index>();
        int[] xMove = new int[]{0, 1, 0, -1};
        int[] yMove = new int[]{1, 0, -1, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Index zombie = new Index(i, j);
                    queue.offer(zombie);
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Index zombie = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Index dead = new Index(zombie.x + xMove[j], zombie.y + yMove[j]);  
                    if (inbound(dead.x, dead.y) && grid[dead.x][dead.y] == 0) {
                        queue.offer(dead);
                        grid[dead.x][dead.y] = 1;
                    }
                }
            }
            step++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    return -1;
                }
            }
        }
        return step - 1;
    }
    private boolean inbound(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return true;
    }
}
