/*
Runtime: 1 ms, faster than 95.98% of Java online submissions for Flood Fill.
Memory Usage: 43.4 MB, less than 73.39% of Java online submissions for Flood Fill.

Algorithm: DFS

Corner case:
normally in DFS, we change values to # once we've seen it 
now the edge case is when newColor == original color, which will cause infinite recursion
*/
//////////////////////////////////////////////////////////////////////
class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int value = image[sr][sc];
    if(value == newColor) return image;   //important!
    dfs(image, sr, sc, newColor, value);
    return image;
  }
  
  public void dfs(int[][] image, int sr, int sc, int newColor, int value){
    if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != value) return;
    image[sr][sc] = newColor;
    dfs(image, sr-1, sc, newColor, value);
    dfs(image, sr+1, sc, newColor, value);
    dfs(image, sr, sc-1, newColor, value);
    dfs(image, sr, sc+1, newColor, value);
  }
}
