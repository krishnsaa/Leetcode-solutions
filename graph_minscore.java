import java.util.ArrayList;
import java.util.List;

public class graph_minscore {
    int mainscore;
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> graph =new ArrayList<>();
        for(int i=0;i<n+1;i++) graph.add(new ArrayList<>());
        for(int[] road: roads){
            graph.get(road[0]).add(new int[]{road[1],road[2]});
            graph.get(road[1]).add(new int[]{road[0],road[2]});
        }
        boolean[] visited =new boolean[n+1];
        mainscore=Integer.MAX_VALUE;
        dfs(graph,1,visited);
        return mainscore==Integer.MAX_VALUE? 0:mainscore;
    }
    public void dfs(List<List<int[]>> graph,int curr, boolean[] visited){
        visited[curr]=true;
        for(int[] next:graph.get(curr)){
            int nn=next[0];
            int nw=next[1];
            mainscore=Math.min(nw,mainscore);
            if(visited[nn]) continue;
            dfs(graph,nn,visited);
        }

    }
// class Solution {
//     public int minScore(int n, int[][] roads) {
//         List<List<int[]>> graph = new ArrayList<>();

//         for (int i = 0; i <= n; i++)
//             graph.add(new ArrayList<>());

//         for (int[] road : roads) {
//             graph.get(road[0]).add(new int[]{road[1], road[2]});
//             graph.get(road[1]).add(new int[]{road[0], road[2]});
//         }

//         Queue<Integer> q = new ArrayDeque<>();
//         boolean[] visited = new boolean[n + 1];

//         q.offer(1);
//         visited[1] = true;

//         int ans = Integer.MAX_VALUE;

//         while (!q.isEmpty()) {
//             int node = q.poll();

//             for (int[] edge : graph.get(node)) {
//                 ans = Math.min(ans, edge[1]);

//                 if (!visited[edge[0]]) {
//                     visited[edge[0]] = true;
//                     q.offer(edge[0]);
//                 }
//             }
//         }

//         return ans;
//     }
// }
    
}
