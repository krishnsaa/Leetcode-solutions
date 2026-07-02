import java.util.*;
public class merge_sort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
        String[] parts=n.trim().split("\\s+");
        int[] arr=new int[parts.length];
        for(int i=0;i<parts.length;i++){
            arr[i]=Integer.parseInt(parts[i]);
        }
        mergesort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
    public static void mergesort(int[] arr , int left,int right){
        if(left>=right) return;
        int mid = left+(right-left) / 2;
        mergesort(arr, left, mid);
        mergesort(arr, mid+1, right);
        merge(arr,left,mid,right);
    }
    public static void merge(int[] arr, int left, int mid , int right){
        int n1=mid-left+1;
        int n2=right-mid;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=arr[left+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=arr[mid+i+1];
        }
        int i=0;
        int j=0;
        int k=left;
        while(i<n1 && j<n2){
            if(L[i]<R[j]){
                arr[k++]=L[i];
                i++;
            }else{
                arr[k++]=R[j];
                j++;
            }

        }
        while(i<n1){
            arr[k++]=L[i++];
        }
        while(j<n2){
            arr[k++]=R[j++];

        }
    }
    
}
