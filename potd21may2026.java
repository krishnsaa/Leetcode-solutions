import java.util.HashSet;
import java.util.Set;
public class potd21may2026 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> hs=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            String s=String.valueOf(arr1[i]);
            int num=s.charAt(0)-'0';
            hs.add(num);
            for(int j=1;j<s.length();j++){
                int digit=s.charAt(j)-'0';
                num=num*10+digit;
                hs.add(num);
            }
        }
        int result=0;
        for(int i=0;i<arr2.length;i++){
            String s=String.valueOf(arr2[i]);
            int num=s.charAt(0)-'0';
            if(!hs.contains(num)) continue;
            int count=1;
            result=Math.max(result,count);
            for(int j=1;j<s.length();j++){
                int digit=s.charAt(j)-'0';
                num=num*10+digit;
                if(!hs.contains(num)) break;
                count++;
                result=Math.max(result,count);
            }
        }
        return result;
    }
}
