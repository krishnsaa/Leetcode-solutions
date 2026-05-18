import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class isvalid {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<s.length() && j<s.length()){
            if(valid(i,j,s)){
                list.add(j-i+1);
                i=j+1;
            }
            j++;
        }
        return list;

        
    }
    public boolean valid(int a,int b,String s){
        int[] arr = new int[26];
        Arrays.fill(arr,0);
        for(int i=a;i<=b;i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=b+1;i<s.length();i++){
            if(arr[s.charAt(i)-'a']>0){
                return false;
            }
        }
        for(int i=0;i<a;i++){
            if(arr[s.charAt(i)-'a']>0){
                return false;
            }
            
        }
        return true;
    }
}
    
