package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class KnightShortestPath {
    private int xLength = 0;
    private int yLength = 0;
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || source == null || destination == null) {
            return -1;
        }
        xLength = grid.length;
        yLength = grid[0].length;
        if (!inbound(source.x, source.y) || !inbound(destination.x, destination.y)) {
            return -1;
        }
        if (grid[source.x][source.y] == true || grid[destination.x][destination.y] == true) {
            return -1;
        }
        int[] xMove = new int[]{1, 1, -1, -1, 2, 2, -2, -2};
        int[] yMove = new int[]{2, -2, 2, -2, 1, -1, 1, -1};
        int step = 0;
        Queue<Point> points = new LinkedList<Point>();
        points.offer(source);
        while (!points.isEmpty()) {
            int size = points.size();  // The way count levels.
            for (int j = 0; j < size; j++) {
                Point point = points.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return step;
                }
                for (int i = 0; i < 8; i++) {
                    Point nextPoint = new Point(point.x + xMove[i], point.y + yMove[i]);
                    if (inbound(point.x + xMove[i], point.y + yMove[i])
                            && !grid[point.x + xMove[i]][point.y + yMove[i]]) {
                        points.offer(nextPoint);
                        grid[nextPoint.x][nextPoint.y] = true;
                        // It is really important to block illegal points in the next round
                        // Not this round because the next round is exponentially greater.
                    }
                }                
            }
            step++;
        }
        return -1;
    }
    private boolean inbound(int x, int y) {
        if (x >= xLength || x < 0) {
            return false;
        }
        if (y >= yLength || y < 0) {
            return false;
        }
        return true;
    }
}
