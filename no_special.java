class no_special {
    public int numberOfSpecialChars(String word) {
        int[] lower=new int[26];
        int[] upper = new int[26];
        for(int i=0;i<word.length();i++){
            int a = word.charAt(i)-'a';
            int A = word.charAt(i)-'A';
            if(a >=0 && a<=26){
                lower[a]++;
            }else{
                upper[A]++;
            }
        }
        int count=0;
        for(int i=0;i<26;i++){
            if(upper[i]>0 && lower[i]>0) count++;
        }
        return count;
        
    }
}