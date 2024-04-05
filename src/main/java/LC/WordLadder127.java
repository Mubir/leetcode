package LC;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder127 {

    public int ladderLength(String start ,String end,String[] dic) {
        int result = 1;
        HashSet<String> holder = new HashSet<>();
        for (String x : dic) {
            holder.add(x);
        }
        result = BFS(start,end,holder,result);
        return result;
    }

    public static int BFS(String start, String end, HashSet<String> holder, int result) {

        Queue<String> q = new LinkedList();
        q.add(start);

        while (!q.isEmpty() ) {
            int size =  q.size();
            for (int k = 0; k < size; k++) {
                String word = q.poll();
                char[] current = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    char restore = current[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if(ch == restore)
                            continue;
                        current[i] = ch;
                        String cand = new String(current);
                        if (cand.equals(end)) {
                            return result+1;
                        }

                        if (holder.contains(cand)) {
                           q.add(cand);
                           holder.remove(cand);
                        }

                    }
                    current[i] = restore;
                }

            }
            result++;

        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        WordLadder127 obj = new WordLadder127();
        System.out.println(obj.ladderLength(beginWord,endWord,wordList)); // out : 5

        String beginWord2 = "hit";

        String endWord2 = "cog";
        String[] wordList2 = {"hot","dot","dog","lot","log"};


        System.out.println(obj.ladderLength(beginWord2,endWord2,wordList2)); // output:
    }
}
