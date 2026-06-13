import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class course_schedule {
    public int[] findOrder(int nc, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();

        for(int i=0;i<nc;i++){
            list.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            list.get(pre[0]).add(pre[1]);
        }

        int[] visited =new int[nc];
        Arrays.fill(visited,0);
        List<Integer> result =new ArrayList<>();
        for(int i=0;i<nc;i++){

            dfs(i,list,visited,result);
        }
        int[] ans = new int[result.size()];

        for(int j=0;j<result.size();j++){
            ans[j]=result.get(j);
        }

        return ans.length==nc ? ans : new int[0]; 
        
    }
    private boolean dfs(int curr, List<List<Integer>> list , int[] visited, List<Integer> result){
        if(visited[curr]==2){
            return true;
        }
        if(visited[curr]==1){
            return false;
        }
        visited[curr]=1;

        List<Integer> currlist = list.get(curr);
        for(int i=0;i<currlist.size();i++){
            if(!dfs(currlist.get(i),list,visited,result)){
                return false;
            }
        }
        visited[curr]=2;
        result.add(curr);
        return true;

    }
}
    
