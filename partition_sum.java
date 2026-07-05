public class partition_sum {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length ;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0) return false;
        Boolean[][] dp = new Boolean[nums.length][sum / 2 + 1];
        return support(nums,0,sum/2,dp);
    }
    boolean support(int[] nums,int curr,int target,Boolean[][] dp){
        if(target==0) return true;
        if(curr==nums.length || target<0){
            return false;
        }
        if(dp[curr][target]!=null) return dp[curr][target];
        boolean take = support(nums,curr+1,target-nums[curr],dp);
        boolean skip = support(nums,curr+1,target,dp);
        return dp[curr][target]=take || skip;
    }

}
