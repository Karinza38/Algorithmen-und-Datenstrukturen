package de.uni_hamburg.ad.Programmieraufgabe3;

import java.util.ArrayList;

public class LongestPathProblem {
  
  int calc(int N, int[][] A) {
    int[] dp = new int[N + 1];
    
    boolean[] visited = new boolean[N + 1];
    
    // Call DFS for every unvisited vertex
    for (int i = 1; i <= N; i++) {
      if (!visited[i])
        dfs(i, A, dp, visited);
    }
    
    int ans = 0;
    
    // Traverse and find the maximum of all dp[i]
    for (int i = 1; i <= N; i++) {
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }
  
  void dfs(int node, int[][] adj, int dp[], boolean visited[]) {
    visited[node] = true;
    // Traverse for all its children
    for (int i = 0; i < adj[node].length; i++) {
      
      // If not visited
      if (!visited[adj[node][i]])
        dfs(adj[node][i], adj, dp, visited);
      
      // Store the max of the paths
      dp[node] = Math.max(dp[node], 1 + dp[adj[node][i]]);
    }
  }
  
}
