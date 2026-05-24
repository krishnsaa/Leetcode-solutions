public class jump_game5 {
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int[] dp=new int[n];
        int result=1;
        for(int i=0;i<n;i++){
            result=Math.max(result,support(i,dp,arr,d));
        }  
        return result;
    }
    
    public int support(int i,int[] dp,int[] arr,int d){
        if(dp[i]!=0) return dp[i];
        int max=1;
        for(int j=i+1;j<=Math.min(i+d,arr.length-1);j++){
            if(arr[j]>=arr[i]) break;
            max=Math.max(max,1+support(j,dp,arr,d));
        }
        for(int j=i-1;j>=Math.max(0,i-d);j--){
            if(arr[j]>=arr[i]) break;
            max=Math.max(max,1+support(j,dp,arr,d));
        }
        return dp[i]=max;
    }
}
