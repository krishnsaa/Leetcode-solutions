import java.util.HashMap;

public class subsequence {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer> mp=new HashMap<>();
        for(int num:nums){
            if(mp.containsKey((long) num)){
                mp.put((long) num,mp.get((long) num)+1);
            }else{
                mp.put((long) num,1);
            }

        }
        int count=0;
        if(mp.containsKey(1L)){
            int ones=mp.get(1L);
            count=(ones%2==0) ? ones-1:ones;
        }
        for(long x:mp.keySet()){
            if(x==1) continue;
            long cur=x;
            int len=1;
            while(mp.getOrDefault(cur,0)>=2){
                long next=cur*cur;
                if(!mp.containsKey(next)){
                    break;
                }
                len+=2;
                cur=next;
            }
            count=Math.max(len,count);
        }
        return count;
    }
}
