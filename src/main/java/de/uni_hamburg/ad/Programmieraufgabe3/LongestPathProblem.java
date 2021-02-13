package de.uni_hamburg.ad.Programmieraufgabe3;

import java.util.ArrayList;

public class LongestPathProblem {

  // Function that returns the longest path
  
  public int calc(int N, int[][] A) {
    //initialize
    ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
    for (int i = 0; i <= N; i++)
    {
      edges.add(new ArrayList<>());
    }
    for(int[] singleEdge : A){
      int startKnoten = singleEdge[0];
      int endKnoten = singleEdge[1];
      edges.get(startKnoten).add(endKnoten);
    }
    
    ArrayList<ArrayList<Integer>> adj = edges;
    // Dp array
    int[] dp = new int[N + 1];
    
    // Visited array to know if the node
    // has been visited previously or not
    boolean[] visited = new boolean[N + 1];
    
    // Call DFS for every unvisited vertex
    for (int i = 1; i <= N; i++) {
      if (!visited[i])
        dfs(i, adj, dp, visited);
    }
    
    int ans = 0;
    
    // Traverse and find the maximum of all dp[i]
    for (int i = 1; i <= N; i++) {
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }
  
  void dfs(int node, ArrayList<ArrayList<Integer>> adj, int dp[],
      boolean visited[]) {
    // Mark as visited
    visited[node] = true;

    // Traverse for all its children
    for (int i = 0; i < adj.get(node).size(); i++) {

      // If not visited
      if (!visited[adj.get(node).get(i)])
        dfs(adj.get(node).get(i), adj, dp, visited);

      // Store the max of the paths
      dp[node] = Math.max(dp[node], 1 + dp[adj.get(node).get(i)]);
    }
  }

}
