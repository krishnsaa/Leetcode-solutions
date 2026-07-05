
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
    
}
