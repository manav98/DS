//PRIM'S ALGORITHM
class MinSpanning
{
    static void printMST(int[] neighbour, int[][] graph)
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < neighbour.length; i++)
            System.out.println(neighbour[i] + "--" + i + "\t" + graph[i][neighbour[i]]);
    }

    static void prims(int[][] graph)
    {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        int[] neighbour = new int[n];
        int[] distance = new int[n];
        for (int i = 0; i < n; i++)
        {
            visited[i] = false;
            //neighbour[i] = -1;
            distance[i] = Integer.MAX_VALUE;
        }
        visited[0] = true;
        neighbour[0] = -1;
        distance[0] = 0;

        int min;
        int k = 0;
        for (int i = 0; i < n - 1; i++)
        {
            min = Integer.MAX_VALUE;
            for (int u = 0; u < n; u++)
            {
                if (!visited[u] && distance[u] < Integer.MAX_VALUE && min > distance[u])
                {
                    min = distance[u];
                    k = u;
                }
            }
            visited[k] = true;
            for (int v = 0; v < n; v++)
            {
                if(!visited[v] && distance[v] > graph[k][v] && graph[k][v] != 0)
                {
                    distance[v] = graph[k][v];
                    neighbour[v] = k;
                }
            }
        }
        printMST(neighbour, graph);
    }

    public static void main(String[] args)
    {
        int[][] graph =
                        {{0, 2, 0, 6, 0},
                        {2, 0, 3, 8, 5},
                        {0, 3, 0, 0, 7},
                        {6, 8, 0, 0, 9},
                        {0, 5, 7, 9, 0}};
        prims(graph);
    }
}

