import java.util.HashMap;
class stringfind {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map =new HashMap<>();
        String find = "balloon";
        for(int i=0;i<find.length();i++){
            char curr=find.charAt(i);
            map.put(curr,0);
        }
        for(int i=0;i<text.length();i++){
            char curr = text.charAt(i);
            if(map.containsKey(curr)){
                int currval=map.get(curr);
                map.put(curr,currval+1);
            }
        }
        int result=Integer.MAX_VALUE;
        for(char key:map.keySet()){
            int val = map.get(key);
            if(key=='l' || key=='o'){
                val=val/2;
            }
            result=Math.min(result,val);
        }
        return result;
        
    }
}