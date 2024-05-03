package LC;


import java.util.ArrayList;
import java.util.List;

class MyTrieNode {
    MyTrieNode[] node = new MyTrieNode[26];
    boolean isWord;

    MyTrieNode() {
        isWord = false;
    }
}

public class MyLeet212 {

    List<String> findWords(char[][] board, String[] words) {
        MyTrieNode trie = buildTrie(words);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                searchMeplz(board, i, j, trie, new StringBuilder(), result);
            }
        }
        return result;
    }

    static void searchMeplz(char[][] board, int i, int j, MyTrieNode trie,
                            StringBuilder build, ArrayList<String> result) {

        char current = board[i][j];

        if (current == '#' || trie.node[current - 'a'] == null) {
            return;
        }
        trie = trie.node[current - 'a'];
        board[i][j] = '#'; // comment it when we can use a letter multibple time in board.
        build.append(current);
        if (trie.isWord) {
            result.add(build.toString());
            trie.isWord = false;// to avoid double counting
        }

        int[][] dxdy = {
                {1, 0}, {0, 1}, {-1, 0}, {0, -1}
        };

        for (int[] d : dxdy) {
            int row = i + d[0];
            int col = j + d[1];
            if (row >= 0 && col >= 0 && row < board.length && col < board[0].length) {
                searchMeplz(board, row, col, trie, build, result);
            }
        }

        board[i][j] = current;
        build.deleteCharAt(build.length() - 1);
    }

    MyTrieNode buildTrie(String[] strings) {
        MyTrieNode temp = new MyTrieNode();
        MyTrieNode current;
        for (String str : strings) {
            char[] tempStr = str.toCharArray();
            current = temp;
            for (int i = 0; i < tempStr.length; i++) {
                if (current.node[tempStr[i] - 'a'] == null) {
                    current.node[tempStr[i] - 'a'] = new MyTrieNode();

                }
                current = current.node[tempStr[i] - 'a'];
            }
            current.isWord = true;
        }
        return temp;
    }

    public static void main(String[] args) {
        MyLeet212 wordSearch = new MyLeet212();

        char[][] board1 = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words1 = {"oath", "pea", "eat", "rain"};
        System.out.println(wordSearch.findWords(board1, words1)); // Output: ["eat","oath"]

        char[][] board2 = {
                {'a', 'b'},
                {'c', 'd'}
        };
        String[] words2 = {"abcb"};
        System.out.println(wordSearch.findWords(board2, words2));

        char[][] board3 = {
                {'a', 'b'},
                {'d', 'c'}
        };
        String[] words3 = {"abcb"};
        System.out.println(wordSearch.findWords(board3, words3)); // Output: []

        char[][] board4 = {{'o', 'a', 'b', 'n'}, {'o', 't', 'a', 'e'}, {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        String[] words4 = {"oa", "oaa"};
        System.out.println(wordSearch.findWords(board4, words4));
    }
}
