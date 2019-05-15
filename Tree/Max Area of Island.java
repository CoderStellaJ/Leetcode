/*
Runtime: 2 ms, faster than 100.00% of Java online submissions for Max Area of Island.
Memory Usage: 43.6 MB, less than 76.83% of Java online submissions for Max Area of Island.

Algorithm: DFS
the same as question Number of Islands

Syntax:
1. matrix.length without () for size!
*/
/////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxarea = 0;
        if(grid.length == 0) return 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    if(area > maxarea){
                      maxarea = area;
                    }
                }
            }
        }
        return maxarea;
    }
    
    int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        int area1 = dfs(grid, i, j-1);
        int area2 = dfs(grid, i-1, j);
        int area3 = dfs(grid, i+1, j);
        int area4 = dfs(grid, i, j+1);
        return area1 + area2 + area3 + area4 + 1;
    }
}
