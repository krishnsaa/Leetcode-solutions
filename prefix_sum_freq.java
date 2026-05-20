import java.util.Arrays;
public class prefix_sum_freq {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n=A.length;
        int[] result=new int[n];
        int[] freq=new int[n+1];
        Arrays.fill(freq,0);
        int count=0;
        for(int i=0;i<n;i++){
            freq[A[i]]++;
            count+=freq[A[i]]==2 ? 1 :0;
            freq[B[i]]++;
            count+=freq[B[i]]==2 ? 1 :0;
            result[i]=count;
        }
        return result;
        
    }

}
