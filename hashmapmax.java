import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hashmapmax {
    public List<String> commonChars(String[] words) {
        List<String> result= new ArrayList<>();
        int n=words.length;
        Map<Character, Integer>[] arr=new HashMap[words.length];
        for(int i=0;i<n;i++){
            arr[i]=new HashMap<>();
        }
        for(int k=0;k<n;k++){
            String word=words[k];
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(arr[k].containsKey(ch)){
                    arr[k].put(ch,arr[k].get(ch)+1);
                }else{
                    arr[k].put(ch,1);
                }
            }
        }
        for(int i=0;i<words[0].length();i++){
            int count=0;
            char ch=words[0].charAt(i);
            for (Map<Character, Integer> arr1 : arr) {
                if (arr1.containsKey(ch) && arr1.get(ch) > 0) {
                    count++;
                    arr1.put(ch, arr1.get(ch) - 1);
                }
            }
            System.out.println(count);
            if(count==n){
                String temp="";
                temp=temp+ch;
                result.add(temp);
            }
        }
        return result;
    }
}
    
