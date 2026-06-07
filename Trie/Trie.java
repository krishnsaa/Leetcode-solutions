package Trie;

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