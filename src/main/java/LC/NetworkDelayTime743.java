package LC;

import java.util.HashMap;
import java.util.PriorityQueue;

public class NetworkDelayTime743 {

    static int nDTime(int[][] w, int n, int start) {
        HashMap<Integer, HashMap<Integer, Integer>> adjList = new HashMap<>();

        for (int[] x : w) {
            if (!adjList.containsKey(x[0])) {
                adjList.put(x[0], new HashMap<>());
            }
            adjList.get(x[0]).put(x[1], x[2]);
        }

        for (int x : adjList.keySet()) {
            for (int y : adjList.get(x).keySet()) {
                System.out.println(x + " -> " + y + " : " + adjList.get(x).get(y));
            }
        }

        System.out.println(adjList.keySet());
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (int[] a, int[] b) -> {
                    return a[1] - b[1];
                }
        );
        HashMap<Integer, Integer> distance = new HashMap<>();

        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int x : adjList.get(current[0]).keySet()) {
                if (distance.containsKey(x) &&
                        adjList.get(current[0]).get(x) + current[1] >= distance.get(x)) {
                    continue;
                }
                queue.add(new int[]{x, adjList.get(current[0]).get(x) + current[1]});
                distance.put(x, adjList.get(current[0]).get(x) + current[1]);
            }
        }
        int maxMin = 0;
        for (int x : distance.keySet()) {
            maxMin = Math.max(maxMin, distance.get(x));
        }

        return maxMin;
    }

    public static void main(String[] args) {

        System.out.println(nDTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }
}
