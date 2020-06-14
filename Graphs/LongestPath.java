//LONGEST PATH TO REACH

import java.util.LinkedList;
import java.util.Queue;

class LongestPath
{

    static int max(int a, int b)
    {
        return a > b ? a : b;
    }

    static int[] tpSort(int[][] adjList)
    {
        int n = adjList.length;
        int[] indegree = new int[n];
        int[] LPT = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < adjList[i].length; j++)
            {
                indegree[adjList[i][j]]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int temp;
        for (int i = 0; i < n; i++)
        {
            if (indegree[i] == 0)
            {
                q.add(i);
            }
        }
        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();
            for (int z = 0; z < adjList[temp].length; z++)
            {
                indegree[adjList[temp][z]]--;
                LPT[adjList[temp][z]] = max(LPT[adjList[temp][z]], LPT[temp] + 1);
                if (indegree[adjList[temp][z]] == 0)
                {
                    q.add(adjList[temp][z]);
                }
            }

        }
        return LPT;
    }

    public static void main(String[] args)
    {
        int[][] adjList = {{2, 3, 4}, {2, 7}, {5}, {5, 7}, {7}, {6}, {7}, {}};
        int[] longest = new int[adjList.length];
        longest = tpSort(adjList);
        System.out.println("Solution is");
        for (int i = 0; i < longest.length; i++)
        {
            System.out.println(longest[i]);
        }
    }
}
