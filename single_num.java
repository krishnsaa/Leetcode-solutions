import java.util.Arrays;

public class single_num {
    public int singleNumber(int[] nums) {
        if(nums.length==1) return nums[0];
        
        Arrays.sort(nums);
        int val=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val && nums[i]!=nums[i+1]){
                return nums[i];
            }else{
                val=nums[i];
            }
            if(i==nums.length-2 && nums[i]!=nums[i+1]  ) return nums[i+1];
        }
        return 0;
    }
}
