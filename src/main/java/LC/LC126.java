package LC;

import java.util.*;


public class LC126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<String>();
        HashSet<String> words = new HashSet<String>();

        for (String x : wordList) {
            words.add(x);
        }

        q.add(beginWord);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                String currentWord = q.poll();
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
