import java.util.Arrays;

public class countsort {
    public int maxIceCream(int[] costs, int coins) {
        int max=0;
        for(int cost: costs){
            max=Math.max(cost,max);
        }
        int[] count=new int[max+1];
        Arrays.fill(count,0);
        for(int cost:costs){
            count[cost]++;
        }
        int maxbuy=0;
        for(int i=1;i<=max;i++){
            int currcount=count[i];

            while(currcount>0 && coins>=i){
                maxbuy++;
                coins=coins-i;
                currcount--;
            }
        }
        return maxbuy;
        
    }
}