import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class binary_search_on_graph {
    // class Solution {
//     int n;
//     public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
//         n=online.length;
//         List<List<int[]>> graph =new ArrayList<>();
//         for(int i=0;i<n;i++) graph.add(new ArrayList<>());
//         for(int[] edge:edges){
//             int u=edge[0];
//             int v=edge[1];
//             int cost=edge[2];
//             graph.get(u).add(new int[]{v,cost});
//         }
//         boolean[] visited=new boolean[n];
//         return support(graph,online,k,visited,Integer.MAX_VALUE,0,0);
        
//     }
//     public int support(List<List<int[]>> graph, boolean[] online, long k, boolean[] visited, int currmin,int currsum,int curr){
//         if(curr==n-1){
//             return (currsum <= k) ? currmin : -1;
//         }
//         int ans=-1;
//         visited[curr]=true;
//         for(int[] next: graph.get(curr)){
//             if(visited[next[0]] || !online[next[0]]) continue;
//             int res= support(graph,online,k,visited,Math.min(currmin,next[1]),(currsum+next[1]),next[0]);
//             if(res!=-1)
//                 ans=Math.max(ans,res);
//         }
//         visited[curr]=false;
//         return ans;
//     }
// }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        int maxEdge = 0;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxEdge = Math.max(maxEdge, e[2]);
        }
        List<Integer> topo = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topo.add(u);

            for (int[] edge : graph.get(u)) {
                if (--indegree[edge[0]] == 0)
                    q.offer(edge[0]);
            }
        }

        int ans = -1;
        int low = 0;
        int high = maxEdge;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid, graph, topo, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int minEdge,
                          List<List<int[]>> graph,
                          List<Integer> topo,
                          boolean[] online,
                          long k,
                          int n) {

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF)
                continue;
            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] edge : graph.get(u)) {

                int v = edge[0];
                int w = edge[1];

                if (w < minEdge)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                dist[v] = Math.min(dist[v], dist[u] + w);
            }
        }

        return dist[n - 1] <= k;
    }
}

