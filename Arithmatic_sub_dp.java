public class Arithmatic_sub_dp {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        if(n<3) return 0;
        int count=0;
        int curr=0;
        for(int i=2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                curr++;
                count=count+curr;
            }else{
                curr=0;
            }
        }
        return count;
    }
}