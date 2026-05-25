class product_subarray {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int maxprod=nums[0];
        int minprod=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int temp=maxprod;
                maxprod=minprod;
                minprod=temp;
            }
            maxprod=Math.max(nums[i],maxprod*nums[i]);
            minprod=Math.min(nums[i],minprod * nums[i]);
            ans=Math.max(ans,maxprod);
        }
        return ans;
    }
}

//  with memoization

class Solution {

    HashMap<String, Integer> memo = new HashMap<>();
    int ans = Integer.MIN_VALUE;

    public int maxProduct(int[] nums) {

        support(nums, 0, 1);

        return ans;
    }

    public int support(int[] nums, int i, int product) {

        if (i >= nums.length) {
            return product;
        }

        String key = i + "#" + product;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // continue current subarray
        int use = product * nums[i];

        ans = Math.max(ans, use);

        int take = support(nums, i + 1, use);

        // start new subarray from current index
        ans = Math.max(ans, nums[i]);

        int restart = support(nums, i + 1, nums[i]);

        int result = Math.max(take, restart);

        memo.put(key, result);

        return result;
    }
}