package PhoneNumberList;

public class Solution {

    public boolean solution(String[] phone_book) {
        //트라이
        Trie root = new Trie();
        for (String phone : phone_book) {
            Trie cur = root;

            for (int i = 0; i < phone.length(); i++) {
                if (cur.isEnd) {
                    return false;
                } else {
                    int next = phone.charAt(i) - '0';
                    if (cur.next[next] == null) {
                        cur.next[next] = new Trie();
                        cur = cur.next[next];

                        if (i == phone.length() - 1) {
                            cur.isEnd = true;
                        }
                    } else {
                        cur = cur.next[next];
                        if (i == phone.length() - 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    class Trie {

        Trie[] next = new Trie[10];
        boolean isEnd = false;
    }
}
