//BREADTH FIRST SEARCH

import java.util.LinkedList;
import java.util.Queue;

class BFS {
    static boolean bfs(int[][] adjList, int source, int destination) {
        boolean isReachable = false;
        int[] visited = new int[adjList.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int temp = q.peek();
            q.remove();
            if (visited[destination] == 1) {
                isReachable = true;
                break;
            }
            for (int k = 0; k < adjList[temp].length; k++) {
                if (visited[adjList[temp][k]] == 0) {
                    visited[adjList[temp][k]] = 1;
                    q.add(adjList[temp][k]);
                }
            }
        }
        return isReachable;
    }

    public static void main(String[] args) {
        int[][] adjList = { { 2, 3, 4 }, { 1, 3 }, { 1, 2 }, { 1, 5, 8 }, { 4, 6, 7 }, { 5, 7, 8, 9 }, { 5, 6 },
                { 4, 6, 9 }, { 6, 8, 10 }, { 9 } };
        for (int source = 1; source < 9; source++) {
            for (int destination = source + 1; destination < 10; destination++) {
                boolean isReachable = bfs(adjList, source - 1, destination - 1);
                if (isReachable)
                    System.out.println(destination + " node is reachable from " + source + " node");
                else
                    System.out.println(destination + " node is NOT reachable from " + source + " node");
            }
        }
    }
}