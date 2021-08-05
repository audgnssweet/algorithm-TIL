package NumberOfIslands;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, j, i);
                    ++result;
                }
            }
        }

        return result;
    }

    private void dfs(char[][] grid, int x, int y) {
        grid[y][x] = '0';

        if (y > 0 && grid[y - 1][x] == '1') {
            dfs(grid, x, y - 1);
        }
        if (x < grid[y].length - 1 && grid[y][x + 1] == '1') {
            dfs(grid, x + 1, y);
        }
        if (y < grid.length - 1 && grid[y + 1][x] == '1') {
            dfs(grid, x, y + 1);
        }
        if (x > 0 && grid[y][x - 1] == '1') {
            dfs(grid, x - 1, y);
        }
    }
}
