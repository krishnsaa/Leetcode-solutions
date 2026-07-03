import java.util.ArrayList;
import java.util.List;

public class graph_min_max_path {
    int n;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n=online.length;
        List<List<int[]>> graph =new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int cost=edge[2];
            graph.get(u).add(new int[]{v,cost});
        }
        boolean[] visited=new boolean[n];
        return support(graph,online,k,visited,Integer.MAX_VALUE,0,0);
        
    }
    public int support(List<List<int[]>> graph, boolean[] online, long k, boolean[] visited, int currmin,int currsum,int curr){
        if(curr==n-1){
            return (currsum <= k) ? currmin : -1;
        }
        int ans=-1;
        visited[curr]=true;
        for(int[] next: graph.get(curr)){
            if(visited[next[0]] || !online[next[0]]) continue;
            int res= support(graph,online,k,visited,Math.min(currmin,next[1]),(currsum+next[1]),next[0]);
            if(res!=-1)
                ans=Math.max(ans,res);
        }
        visited[curr]=false;
        return ans;
    }
}