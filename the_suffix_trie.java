import Trie.Trie;
public class the_suffix_trie {
    public int[] stringIndices(String[] words, String[] wordsQ) {
        int n=wordsQ.length;
        int m=words.length;
        int[] result=new int[n];
        Trie tree= new Trie();
        for(int i=0;i<m;i++){
            tree.insert(new StringBuilder(words[i]).reverse().toString(),i);
        }
        for(int i=0;i<n;i++){
            String word=new StringBuilder(wordsQ[i]).reverse().toString();
            result[i]=tree.search(word);
        }        
        return result;
    }
}
