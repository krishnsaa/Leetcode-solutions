import java.util.ArrayList;
import java.util.List;

public class combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(n,k,new ArrayList<>() ,result );
        return result;
    }
    public void backTrack(int n,int k, List<Integer> curr,List<List<Integer>> result ){
        if(curr.size()==k){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=1;i<=n;i++){
            if(curr.contains(i)) continue;
            if(curr.size()>0 && i<curr.get(curr.size()-1)) continue;
            curr.add(i);
            backTrack(n,k,curr,result);
            curr.remove(curr.size()-1);
        }

    }
}