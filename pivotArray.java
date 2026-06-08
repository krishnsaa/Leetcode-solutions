public class pivotArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int i1=0;
        int j1=n-1;
        int[] result=new int[n];
        while(i<n && j>=0){
            if(nums[i]<pivot){
                result[i1++]=nums[i];
            }
            if(nums[j]>pivot){
                result[j1--]=nums[j];
            }
            i++;
            j--;
        }
        for(int p=i1;p<=j1;p++){
            result[p]=pivot;
        }
        // ArrayList<Integer> smaller = new ArrayList<>();
        // ArrayList<Integer> equal = new ArrayList<>();
        // ArrayList<Integer> greater = new ArrayList<>();
        // for(int num : nums){
        //     if(num < pivot){
        //         smaller.add(num);
        //     }
        //     else if(num == pivot){
        //         equal.add(num);
        //     }
        //     else{
        //         greater.add(num);
        //     }
        // }
        // int[] result = new int[nums.length];
        // int idx = 0;
        // for(int num : smaller){
        //     result[idx++] = num;
        // }
        // for(int num : equal){
        //     result[idx++] = num;
        // }
        // for(int num : greater){
        //     result[idx++] = num;
        // }
        return result;
    }
}