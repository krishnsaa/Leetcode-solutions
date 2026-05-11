import java.util.*;
class separate_num {
    public int[] separateDigits(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        for(int i=n-1;i>=0;i--){
            int current=nums[i];
            while(current>0){
                list.add(0,current%10);
                current=current/10;
            }
        }
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result; 
    }
}