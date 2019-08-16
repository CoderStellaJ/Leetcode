/*
Runtime: 1 ms, faster than 80.94% of Java online submissions for Redundant Connection.
Memory Usage: 40.7 MB, less than 45.45% of Java online submissions for Redundant Connection.

Union-Find Problem
Similar to Accounts Merge
*/
///////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
      DSU dsu = new DSU();
      int[] ans = new int[2];
      for(int[] edge: edges) {
        int parent1 = dsu.find(edge[0]);
        int parent2 = dsu.find(edge[1]);
        if(parent1 == parent2) ans = edge;
        else dsu.union(edge[0], edge[1]);
      }
      return ans;       
    }
  
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[][] edges1 = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
    int[] ans = sol.findRedundantConnection(edges1);
    System.out.println(ans[0] + " " + ans[1]);
    int[][] edges2 = {{1,2}, {1,3}, {2,3}};
    int[] ans1 = sol.findRedundantConnection(edges2);
    System.out.println(ans1[0] + " " + ans1[1]); 
  }
}

class DSU {
  int[] parents;
  public DSU() {
    parents = new int[1001];
    for(int i = 0; i <= 1000; i++) {
      parents[i] = i;
    }
  }
  
  public int find(int x) {
    if(parents[x] != x) parents[x] = find(parents[x]);
    return parents[x];
  }
  
  public void union(int x, int y) {
    parents[find(x)] = find(y);
  }
}
