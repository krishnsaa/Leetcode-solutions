import java.util.*;
public class quick_sort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        String[] starr=line.trim().split("\\+s");
        int[] arr=new int[starr.length];
        for(int i=0;i<starr.length;i++){
            arr[i]=Integer.parseInt(starr[i]);
        }
        
        sc.close();
    }

}
