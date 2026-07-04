import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class safeNode_graph {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> safe=new ArrayList<>();
        int[] state=new int[n];
        Arrays.fill(state,0);
        for(int i=0;i<n;i++){
            if(dfs(graph,state,i)){
                safe.add(i);
            }
        }
        return safe;
    }
    boolean dfs(int[][] graph,int[] state, int curr){
        if (state[curr] == 2) return true;
        if (state[curr] == 3) return false;
        if (state[curr] == 1) return false;
        state[curr]=1;
        for(int i : graph[curr]){
            if(!dfs(graph,state,i)){
                state[curr]=3;
                return false;
            }
        }
        state[curr]=2;
        return true;
    }
}