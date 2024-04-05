package LC;


import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}

public class Leet212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, new StringBuilder(), result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, StringBuilder sb, List<String> result) {
        char c = board[i][j];
        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }

        sb.append(c);
        node = node.children[c - 'a'];

        if (node.isEnd) {
            result.add(sb.toString());
            node.isEnd = false; // Mark the word as found to avoid duplicates
        }

        board[i][j] = '#'; // Mark the cell as visited

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                dfs(board, newRow, newCol, node, sb, result);
            }
        }

        board[i][j] = c; // Restore the cell
        sb.deleteCharAt(sb.length() - 1); // Backtrack
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }
        return root;
    }

    public static void main(String[] args) {
        Leet212 wordSearch = new Leet212();

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
        System.out.println(wordSearch.findWords(board2, words2)); // Output: []

        char[][] board3 = {
                {'a','b'},
                {'d','c'}
        };
        String[] words3 = {"abcb"};
        System.out.println(wordSearch.findWords(board3, words3)); // Output: []
    }
}
