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

    class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
    int ind=-1;
    int length=Integer.MAX_VALUE;
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word,int indexw) {
            TrieNode curr = root;
            int len=word.length();

            for (char c : word.toCharArray()) {
                int index = c - 'a';


                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }

                if(len<curr.length){
                    curr.length=len;
                    curr.ind=indexw;
                }
                curr = curr.children[index];
                if(len<curr.length){
                    curr.length=len;
                    curr.ind=indexw;
                }
            }

            curr.isEndOfWord = true;
        }


        public int search(String word) {
            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    return curr.ind;
                }

                curr = curr.children[index];
            }

            return curr.ind;
        }
    }
}
