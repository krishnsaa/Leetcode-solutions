import java.util.Arrays;

public class advaced_bucket {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        int minVal = Arrays.stream(nums).min().getAsInt();
        int maxVal = Arrays.stream(nums).max().getAsInt();
        
        if (minVal == maxVal) {
            return 0;
        }
        int n = nums.length;
        int bucketSize = Math.max(1, (maxVal - minVal) / (n - 1));
        int numBuckets = (maxVal - minVal) / bucketSize + 1;
        
        int[] bucketMin = new int[numBuckets];
        int[] bucketMax = new int[numBuckets];
        boolean[] bucketFilled = new boolean[numBuckets];
        
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int num : nums) {
            int index = (num - minVal) / bucketSize;
            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
            bucketFilled[index] = true;
        }
        int maxGap = 0;
        int prevMax = minVal;
        
        for (int i = 0; i < numBuckets; i++) {
            if (!bucketFilled[i]) continue;
            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }
        
        return maxGap;
    }
}