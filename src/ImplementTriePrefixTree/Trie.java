package ImplementTriePrefixTree;

public class Trie {

    static final int ALPHABET_SIZE = 26;

    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node now = root;
        for (char ch : word.toCharArray()) {
            if (now.child[ch - 'a'] == null) {
                now = insert(now, ch);
            } else {
                now = now.child[ch - 'a'];
            }
        }
        now.isTerminal = true;
    }

    private Node insert(Node now, char ch) {
        now.child[ch - 'a'] = new Node();
        now = now.child[ch - 'a'];
        now.val = ch;

        return now;
    }

    public boolean search(String word) {
        Node now = root;
        for (char ch : word.toCharArray()) {
            if (now.child[ch - 'a'] == null) {
                return false;
            } else {
                now = now.child[ch - 'a'];
            }
        }
        return now.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Node now = root;
        for (char ch : prefix.toCharArray()) {
            if (now.child[ch - 'a'] == null) {
                return false;
            } else {
                now = now.child[ch - 'a'];
            }
        }
        return true;
    }

    class Node {

        Node[] child = new Node[ALPHABET_SIZE];
        boolean isTerminal = false;
        char val;
    }

}
