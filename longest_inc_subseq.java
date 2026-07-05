import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class longest_inc_subseq {
    //BruteForce

    // int max=0;
    // public int lengthOfLIS(int[] nums) {
    //     findLength(nums,0,new ArrayList<>());
    //     return max;
    // }
    // void findLength(int[] nums,int i,List<Integer> list){
    //     if(i>=nums.length){
    //         if(increasing(list))
    //         max=Math.max(max,list.size());
    //         return;
    //     }
    //     findLength(nums,i+1,list);
    //     list.add(nums[i]);
    //     findLength(nums,i+1,list);
    //     list.remove(list.size() - 1);
    // }
    // boolean increasing(List<Integer> list){
    //     int temp=0;
    //     for(int i=0;i<list.size();i++){
    //         if(list.get(i)<=temp){
    //             return false;
    //         }
    //         temp=list.get(i);
    //     }
    //     return true;
    // }
    

    // Memoization on Recursion
    // public int lengthOfLIS(int[] nums) {
    //     int n=nums.length;
    //     int[][] dp=new int[n][n];
    //     for(int i=0;i<n;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return findLength(nums,0,-1,dp);
    // }
    // int findLength(int[] nums,int i,int prev,int[][] dp){
    //     if(i==nums.length){
    //         return 0;
    //     }
    //     if(dp[i][prev+1]!=-1) return dp[i][prev+1];
    //     int len = 0 + findLength(nums,i+1,prev,dp);
    //     if(prev==-1 || nums[i]>nums[prev]){
    //         len=Math.max(1+findLength(nums,i+1,i,dp),len);
    //     }
    //     return dp[i][prev+1]=len;
    // }
    // class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;

//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);

//         int ans = 1;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < i; j++) {

//                 if (nums[j] < nums[i]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }

//             ans = Math.max(ans, dp[i]);
//         }

//         return ans;
//     }
// }
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {

            int idx = Collections.binarySearch(lis, num);

            if (idx < 0)
                idx = -(idx + 1);

            if (idx == lis.size())
                lis.add(num);
            else
                lis.set(idx, num);
        }

        return lis.size();
    }
}



}
