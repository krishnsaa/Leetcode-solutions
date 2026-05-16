import java.util.Arrays;

public class handofstraight {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(groupSize==1) return true;
        int n=hand.length;
        if(n%groupSize!=0) return false;
        Arrays.sort(hand);
        int count=n/groupSize;
        while(count>0){
            int[] arr=new int[groupSize];
            int j=0;
            for(int i=0;i<n;i++){
                if(j==arr.length) break;
                if(hand[i]==-1) continue;
                if(j==0){
                    arr[j++]=hand[i];
                    hand[i]=-1;
                }else if(hand[i]-arr[j-1]==1){
                    arr[j++]=hand[i];
                    hand[i]=-1;
                }
            }
            count--;
        }
        for(int i=0;i<n;i++) if(hand[i]!=-1) return false;
        return true;
        
    }
}
    

