package lintcode;

public class BombEnemy {
	
	int height, width;
	
	/**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
    	height = grid.length;
    	if (height > 0) {
    		width = grid[0].length;
    	} else {
    		return 0;
    	}
    	int maxKill = 0;
    	for (int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {
    			if (grid[i][j] == '0') {
    				maxKill = Math.max(maxKill, bomb(i, j, grid));
    			}
    		}
    	}
    	return maxKill;
    }
    
    private int bomb(int x, int y, char[][] grid) {
    	int kill = 0;
    	// Faster than break
    	for (int i = x; i < height && grid[i][y] != 'W'; i++) {
    		if (grid[i][y] == 'E') {
    			kill++;
    		}
    	}
    	for (int i = x; i > -1 && grid[i][y] != 'W'; i--) {
    		if (grid[i][y] == 'E') {
    			kill++;
    		}
    	}
    	for (int i = y; i < width && grid[x][i] != 'W'; i++) {
    		if (grid[x][i] == 'E') {
    			kill++;
    		}
    	}
    	for (int i = y; i > -1 && grid[x][i] != 'W'; i--) {
    		if (grid[x][i] == 'E') {
    			kill++;
    		}
    	}
    	return kill;
    }
}
