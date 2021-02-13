package de.uni_hamburg.ad.Programmieraufgabe3;

import java.util.ArrayList;

public class LongestPathProblem {

  // Function that returns the longest path

  public int calc(int N, int[][] A) {
    //initialize
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

    for(int[] edge : A) adj.get(edge[0]).add(edge[1]);

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

  void dfs(int root, ArrayList<ArrayList<Integer>> adj, int[] dp,  boolean[] visited) {
    // Mark as visited
    visited[root] = true;

    // Traverse for all its children
    for (Integer neighbour : adj.get(root))
    {
      // If not visited
      if (!visited[neighbour])
        dfs(neighbour, adj, dp, visited);

      // Store the max of the paths
      dp[root] = Math.max(dp[root], 1 + dp[neighbour]);
    }
  }

}
