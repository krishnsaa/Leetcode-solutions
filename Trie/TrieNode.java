package Trie;

class TrieNode {
TrieNode[] children = new TrieNode[26];
boolean isEndOfWord = false;
int ind=-1;
int length=Integer.MAX_VALUE;
}