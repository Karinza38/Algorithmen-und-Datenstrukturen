package de.uni_hamburg.ad.Programmieraufgabe3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongestPathProblem {

  int calc(int N, int[][] A) {
    ArrayList<ArrayList<Integer>> adj = parseAdj(A);
    int[] dp = new int[N + 1];

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

  private ArrayList<ArrayList<Integer>> parseAdj(int[][] a)
  {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>(9001);
    for (int[] edges : a) {
      final int startNode = edges[0];
      final int endNode = edges[1];
      while(adj.size() <= startNode) adj.add(new ArrayList<>());
      adj.get(startNode).add(endNode);
    }
    return adj;
  }

  void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] dp, boolean[] visited) {
    visited[node] = true;
    // Traverse for all its children
    if (adj.size() <= node) return;
    for (Integer neighbour : adj.get(node)) {

      // If not visited
      if (!visited[neighbour])
        dfs(neighbour, adj, dp, visited);

      // Store the max of the paths
      dp[node] = Math.max(dp[node], 1 + neighbour);
    }
  }
  
}
