import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class find_k_smallest_minheap_with_373 {

    class Pair {
        int sum;
        int i;
        int j;

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> minHeap =new PriorityQueue<>((a,b) -> a.sum - b.sum);
        for(int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new Pair(nums1[i] + nums2[0], i, 0));
        }

        while(k-- > 0 && !minHeap.isEmpty()) {

            Pair curr = minHeap.poll();

            result.add(Arrays.asList(
                nums1[curr.i],
                nums2[curr.j]
            ));
            if(curr.j + 1 < nums2.length) {
                minHeap.offer(
                    new Pair(
                        nums1[curr.i] + nums2[curr.j + 1],
                        curr.i,
                        curr.j + 1
                    )
                );
            }
        }

        return result;
    }
}
    
