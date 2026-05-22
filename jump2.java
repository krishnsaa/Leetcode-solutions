import java.util.Arrays;
public class jump2 {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,0);
        return support(start,arr,dp);
    }
    public boolean support(int i,int[] arr,int[] dp){
        int n=arr.length;
        if(i>=n || i<0 || dp[i]==1) {
            return false;
        }
        dp[i]=1;
        if(arr[i]==0) return true;
        return support(i-arr[i],arr,dp) || support(i+arr[i],arr,dp);
    }
}
