import java.util.ArrayList;
import java.util.List;

public class province_graph {
    public int findCircleNum(int[][] isConnected) {
        int province=0;
        int n= isConnected.length;
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && j!=i){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            province++;
            support(i,graph,visited);
        }
        return province;
        
    }
    void support(int i, List<List<Integer>> graph, boolean[] visited){
        if(visited[i]) return ;
        visited[i]=true;
        for(int next:graph.get(i)){
            support(next,graph,visited);
        }
    }
}