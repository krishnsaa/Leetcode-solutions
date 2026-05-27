import java.util.HashMap;
import java.util.Map;
public class special_char_2 {
    public int numberOfSpecialChars(String word) {
        Map<Character,Integer> mpl = new HashMap<>();
        Map<Character,Integer> mpu = new HashMap<>();
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(Character.isLowerCase(ch)){
                if(mpl.get(ch)==null){
                    mpl.put(ch,i);
                }else{
                    mpl.put(ch,i);
                }
            }else{
                if(mpu.get(ch)==null){
                    mpu.put(ch,i);
                }
            }
        }
        int count=0;
        for (Map.Entry<Character, Integer> entry : mpl.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            char keyu=Character.toUpperCase(key);
            if(mpu.get(keyu)!=null){
                if(value<mpu.get(keyu)) count++;
            }

        }

        return count;
    }
}
