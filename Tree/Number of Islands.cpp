////////////////////////////////////////////////////////////////////////
/*
Runtime: 12 ms, faster than 99.20% of C++ online submissions for Number of Islands.
Memory Usage: 10.7 MB, less than 100.00% of C++ online submissions for Number of Islands.
Complexity:
O(N+M), N is the numebr of cells and M is the number os '1's in the grid
DFS: Depth first search, for union find questions
Algorithm:
DFS each node for its neighbors which are 1
when each dfs returns, it means this whole union has been gone through
*/
/////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.empty() || grid[0].size() == 0) return 0;
        int numrow = grid.size();
        int numcol = grid[0].size();
        int count = 0;
        for(int i = 0; i < numrow; i++) {
            for(int j = 0; j < numcol; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(vector<vector<char>>& grid, int i, int j) {
        if(i < 0 || i >= grid.size() || j < 0 || j >= grid[0].size() || grid[i][j] != '1') return;
        grid[i][j] = '#';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
};
