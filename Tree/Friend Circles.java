/*
Runtime: 2 ms, faster than 72.21% of Java online submissions for Friend Circles.
Memory Usage: 43.6 MB, less than 53.66% of Java online submissions for Friend Circles.

Algorithm: Union Find
create a seperate class for UnionFind
Attributes:
1. public int components
2. private int[] parents: root of the component should be assigned to each node in the component
Methods:
1. constructor: initialize components and parents
2. find(int i): return the root of that component. Note: modify each node's parents in the process
3. union: deduct #components and assign roota as the root of rootb

Note:
This question is different from Number of Islands. DFS doesn't work
e.g.
1001
0110
0111
1011
1

Syntax:
1. initialize a 2D array 
String[][] names = { {"Sam", "Smith"}, {"Robert", "Delgro"}, {"James", "Gosling"}, };
*/
////////////////////////////////////////////////////////
import java.util.*;

class Solution {
    static int i = 0;
    public int findCircleNum(int[][] M) {
      int len = M.length;
      if(M.length == 0) return 0;
      UnionFind uf = new UnionFind(len);
      for(int i = 0; i < len; i++) {
        for(int j = 0; j < len; j++) {
          if(M[i][j] == 1){
            uf.union(i,j);
          }
        }
      }
      return uf.components;
    }
  
    //for testing
    public static void main(String[] args) {
      Solution mysol = new Solution();
      int[][] matrix = {{1,1,1,1},
                        {1,1,1,1},
                        {1,1,1,1},
                        {1,1,1,1},
                        };
      int ans1 = mysol.findCircleNum(matrix);
      System.out.println("ans1 "+ans1);
    }
  
}

class UnionFind {
    int[] parents;
    public int components = 0;
    //constructor
    public UnionFind(int n){
      parents = new int[n];
      for(int i = 0; i < n; i++) parents[i] = i;
      components = n;
    }
    //find the root
    public int find(int i) {
      if(parents[i] != i) parents[i] = find(parents[i]);    //note: modify parents[i] in the process
      return parents[i];
    }
    //union 2 nodes
    public void union(int a, int b) {
      int roota = find(a);
      int rootb = find(b);
      if(roota == rootb) return;
      parents[roota] = rootb;
      components--;
    }
}
