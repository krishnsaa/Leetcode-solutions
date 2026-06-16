public class stringprocess {
    public String processStr(String s) {
        StringBuilder st=new StringBuilder("");
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='a' && ch<='z'){
                st.append(ch);
            }else if(ch=='*'){
                if(st.length()>0){
                    st.deleteCharAt(st.length()-1);
                }
            }else if(ch=='#'){
                st.append(st);
            }else if(ch=='%'){
                st.reverse();
            }
        }

        return st.toString();
    }
}