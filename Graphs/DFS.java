//DEPTH FIRST SEARCH

public class DFS
{
    static void ddfs(int[][] adjList, boolean[] visited, int source, int destination)
    {
        visited[source] = true;
        if (source == destination)
        {
            return;
        }
        for (int i = 0; i < adjList[source].length; i++)
        {
            if (!visited[adjList[source][i]])
            {
                ddfs(adjList, visited, adjList[source][i], destination);
            }
        }
    }

    static boolean DepthSearch(int[][] adjList, int source, int destination)
    {
        boolean[] visited = new boolean[adjList.length];
        ddfs(adjList, visited, source, destination);
        return visited[destination];
    }

    public static void main(String[] args)
    {
        int[][] adjList = {{1, 2, 3}, {0, 2}, {0, 1}, {0, 4, 7}, {3, 5, 6}, {4, 6, 7, 8}, {4, 5},
                {3, 5, 8}, {5, 7, 9}, {8}};
        int source = 0;
        int destination = 9;
        boolean isReachable = DepthSearch(adjList, source, destination); //Check if destination node can be reached by source node
        if (isReachable)
        {
            System.out.println(source + " can be reached to this " + destination);
        }
    }
}
