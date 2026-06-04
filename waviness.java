public class waviness {
    public int totalWaviness(int num1, int num2) {
        int sum = 0;
        while(num1 <=num2){
            sum=sum+wavi(num1++);
        }
        System.out.print(wavi(4848));
        return sum;
        
    }
    public int wavi(int n){
        if(n < 100) return 0;
        int pre=-1;
        int per=-1;
        int next=-1;
        int count=0;
        while(n>0){
            int curr=n%10;
            n=n/10;
            if(pre == -1) {
                pre = curr;
            }else if(per== -1){
                per = curr;
            }else if(next == -1 ){
                next = curr;
            }else{
                pre = per;
                per = next;
                next=curr;
            }
                if(next!= -1 && per > pre && per > next ) count++;
                if(next!=-1 && per < pre && per < next ) count++;
        }
        return count;

    }
}
