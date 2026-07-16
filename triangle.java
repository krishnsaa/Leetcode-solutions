import java.util.List;

public abstract class triangle {
    // class Solution {
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int[][] dp=new int[triangle.size()][triangle.size()];
//         for(int i=0;i<dp.length;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return support(0,0,triangle,dp);
        
//     }
//     public int support(int i, int j,List<List<Integer>> triangle ,int[][] dp){
//         if(i==triangle.size()-1){
//             return triangle.get(i).get(j);
//         }
//         if(dp[i][j]!=-1) return dp[i][j];
//         return dp[i][j]=triangle.get(i).get(j)+Math.min(support(i+1,j,triangle,dp),support(i+1,j+1,triangle,dp));

//     }
// }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j)+ Math.min(dp[i + 1][j],dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}
