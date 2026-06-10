import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class heap_with_maxSum {
    class pairSum{
        int sum;
        int n1;
        int n2;
        pairSum(int sum,int n1,int n2){
            this.sum=sum;
            this.n1=n1;
            this.n2=n2;
        }

    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<pairSum> Min1 = new PriorityQueue<>((a,b)->a.sum-b.sum);
        List<List<Integer>> result = new ArrayList<>();
        for(int num: nums1){
            for(int num2:nums2){
                Min1.offer(new pairSum(num+num2 , num, num2));
            }
        }
        for(int i=0;i<k;i++){
            pairSum curr = Min1.poll();
            List<Integer> temp = new ArrayList<>();
            temp.add(curr.n1);
            temp.add(curr.n2);

            result.add(temp);
        }
        return result;

        
    }
}
