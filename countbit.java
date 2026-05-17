public class countbit {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        int curr=0;
        for(int i=0;i<=n;i++){
            int count=0;
            int temp=i;
            while(temp>0){
                int bit=temp&1;
                if(bit==1) count++;
                temp=temp>>1;
            }
            arr[curr++]=count;
        }
        return arr;

        
    }
}
    
