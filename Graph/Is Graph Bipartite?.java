/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Graph Bipartite?.
Memory Usage: 44.2 MB, less than 68.58% of Java online submissions for Is Graph Bipartite?.

Complexity:
runtime: O(N)
space: O(N)

Algorithm:
Our goal is trying to use two colors to paint the nodes and see if there are any adjacent nodes having the same color.
Initialize a color[] array for each node. Here are three states for colors[] array:
0: Haven't been colored yet.
1: Blue.
-1: Red.
For each node,
If it hasn't been colored, use a color to paint it. Then use the other color to color all its adjacent nodes (DFS).
If it has been colored, check if the current color is the same as the color that is going to be used to color it. 
*/
//////////////////////////////////////////////////////////////////

class Solution {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colors = new int[n];
    
    for(int i = 0; i < n; i++) {
      if(colors[i] == 0 && validColor(graph, colors, 1, i) == false) {
        return false;
      }
    }
    return true;
  }
  
  public boolean validColor(int[][] graph, int[] colors, int color, int node) {
    if(colors[node] != 0) {
      return colors[node] == color;
    }
    colors[node] = color;
    for(int next : graph[node]) {
      if(validColor(graph, colors, -color, next) == false) {
        return false;
      }
    }
    return true;
  }
}
