/*
Runtime: 1 ms, faster than 89.52% of Java online submissions for Evaluate Division.
Memory Usage: 34.9 MB, less than 95.07% of Java online submissions for Evaluate Division.

Algorithm: DFS
Binary relationship is represented as a graph usually.
Does the direction of an edge matters? -- Yes. Take a / b = 2 for example, it indicates a --2--> b as well as b --1/2--> a.
Thus, it is a directed weighted graph.
In this graph, how do we evaluate division?
Take a / b = 2, b / c = 3, a / c = ? for example,  a --2--> b --3--> c

Syntax:
mymap.putIfAbsent(a, b);

Corner case:
1.
[["a","b"],["b","c"],["bc","cd"]]
[1.5,2.5,5.0]
[["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
*/
//////////////////////////////////////////////////////////////////////

class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      Map<String, Map<String, Double>> graph = buildGraph(equations, values);
      double[] ans = new double[queries.size()];
      for(int i = 0; i < queries.size(); i++)
        ans[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
      return ans;
  }
  
  private double getPathWeight(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
    if(!graph.containsKey(start)) return -1.0;
    if(graph.get(start).containsKey(end)) return graph.get(start).get(end);
    visited.add(start);
    for(Map.Entry<String, Double> neighbor:graph.get(start).entrySet()){
      if(!visited.contains(neighbor.getKey())) {
        double productWeight = getPathWeight(neighbor.getKey(), end, visited, graph);
        if(productWeight != -1.0) return neighbor.getValue() * productWeight;
      }
    }
    return -1.0;
  }
  
  private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    String u, v;
    for(int i = 0; i < equations.size(); i++) {
      u = equations.get(i).get(0);
      v = equations.get(i).get(1);
      graph.putIfAbsent(u, new HashMap<>());
      graph.get(u).put(v, values[i]);
      graph.putIfAbsent(v, new HashMap<>());
      graph.get(v).put(u, 1/values[i]);
    }
    return graph;
  }
}
