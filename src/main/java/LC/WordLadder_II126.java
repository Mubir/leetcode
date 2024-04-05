package LC;

import java.util.*;

public class WordLadder_II126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        List<String> singlePath = new ArrayList<>();
        singlePath.add(beginWord);
        for (String x : wordList) {
            set.add(x);
        }
        if (!set.contains(endWord))
            return new ArrayList<>();
        HashMap<String, List<String>> adjList = BfsForAdjList(beginWord, endWord, wordList, set);
        return dfsForPath(beginWord, endWord, adjList, result, singlePath);
    }

    public static HashMap<String, List<String>> BfsForAdjList(
            String beginWord, String endWord, List<String> wordList, HashSet<String> holder
    ) {

        Queue<String> Q = new LinkedList<>();
        HashMap<String, List<String>> adjList = new HashMap<>();
        HashMap<String, Integer> visitedWithLevel = new HashMap<>();
        Q.add(beginWord);
        visitedWithLevel.put(beginWord, 1);

        while (!Q.isEmpty()) {
            int size = Q.size();
            while (size > 0) {
                String current = Q.poll();
                char[] toChar = current.toCharArray();
                for (int i = 0; i < current.length(); i++) {
                    char restoration = toChar[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == restoration)
                            continue;
                        toChar[i] = ch;
                        String buildString = new String(toChar);

                        if (holder.contains(buildString)) {
                            if (!adjList.containsKey(current)) {
                                adjList.put(current, new ArrayList<>());
                            }

                            if (!visitedWithLevel.containsKey(buildString)) {
                                visitedWithLevel.put(buildString, visitedWithLevel.get(current) + 1);
                                adjList.get(current).add(buildString);
                                Q.add(buildString);

                            } else if (visitedWithLevel.get(buildString) == visitedWithLevel.get(current) + 1) {
                                adjList.get(current).add(buildString);
                            }
                        }
                    }
                    toChar[i] = restoration;
                }
                size--;
            }
        }
        System.out.println(adjList);
        for (String key : adjList.keySet()) {
            List<String> node = adjList.get(key);
            System.out.print(key + " : ");
            for (String x : node) {
                System.out.print(x + "->");
            }
            System.out.println();
        }

        return adjList;
    }

    static List<List<String>> dfsForPath(
            String beginWord,
            String endWord,
            HashMap<String, List<String>> adjList,
            List<List<String>> result,
            List<String> singlePath
    ) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(singlePath));
//            result.add(singlePath);
            return result;
        }
        if (adjList.get(beginWord) == null)
            return new ArrayList<>();
        List<String> node = adjList.get(beginWord);
        for (String x : node) {
            singlePath.add(x);
            dfsForPath(x, endWord, adjList, result, singlePath);
            singlePath.remove(singlePath.size() - 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        WordLadder_II126 obj = new WordLadder_II126();
        System.out.println(obj.findLadders(beginWord, endWord, wordList)); // out : 5

        String beginWord2 = "hit";

        String endWord2 = "cog";
        List<String> wordList2 = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");


        System.out.println(obj.findLadders(beginWord2, endWord2, wordList2)); // output:

        String beginWord3 = "hot";

        String endWord3 = "dog";
        List<String> wordList3 = new ArrayList<>();
        wordList.add("hot");

        wordList.add("dog");



        System.out.println(obj.findLadders(beginWord3, endWord3, wordList3));
    }
}
