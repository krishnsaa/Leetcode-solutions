import java.util.Arrays;
public class longest_seq {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        support(0,dp,nums);
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    public void support(int i,int[] dp ,int [] nums){
        if(i>=nums.length) return;
        for(int j=0;j<i;j++){
            if(nums[j]<nums[i])
                dp[i]=Math.max(dp[j]+1,dp[i]);
        }
        support(i+1,dp,nums);
    }
}
