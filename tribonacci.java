
class tribonacci {
    public int tribonacc(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        int[] dparr=new int[n+1];
        dparr[0]=0;
        dparr[1]=1;
        dparr[2]=1;
        support(dparr,3);
        return dparr[n];

        
    }
    public void support(int[] dparr ,int curr ){
        if(dparr.length==curr) return;
        dparr[curr]=dparr[curr-1]+dparr[curr-2]+dparr[curr-3];
        support(dparr,curr+1);

    }
}