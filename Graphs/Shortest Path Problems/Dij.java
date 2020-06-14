//DIJKASTRA'S ALGORITHM
class Dij
{
    static int[] dijkastra(int[][] graph, int src)
    {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++)
        {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[src] = 0;
        visited[src] = true;
        int k = 0;
        int min;
        for (int i = 0; i < n; i++)
        {
            min = Integer.MAX_VALUE;
            for (int u = 0; u < n; u++)
            {
                if (!visited[u])
                {
                    if (min > distance[u])
                    {
                        min = distance[u];
                        k = u;
                    }
                }
            }
            visited[k] = true;
            for (int j = 0; j < n; j++)
            {
                if (!visited[j] && graph[k][j] > 0)
                {
                    if (distance[j] > distance[k] + graph[k][j])
                    {
                        distance[j] = distance[k] + graph[k][j];
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args)
    {
        int[][] graph =
                {{0, 10, 80, 0, 0, 0, 0},
                        {10, 0, 6, 0, 20, 0, 0},
                        {80, 6, 0, 70, 0, 0, 0},
                        {0, 0, 70, 0, 0, 0, 0},
                        {0, 20, 0, 0, 0, 50, 10},
                        {0, 0, 0, 0, 50, 0, 5},
                        {0, 0, 0, 0, 10, 5, 0}};
        int source = 0;
        int[] shortestPaths = dijkastra(graph, source);
        System.out.println("Vertex" + "\t" + "Distance");
        for (int i = 0; i < shortestPaths.length; i++)
        {
            System.out.println(i + 1 + "\t" + shortestPaths[i]);
        }
    }
}
