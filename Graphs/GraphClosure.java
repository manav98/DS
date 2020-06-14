//FIND CLOSURE OF A GRAPH
//USED FLOYD WARSHALL ALGORITHM
class GraphClosure
{
    private boolean[][] findClosure(int[][] graph)
    {
        int n = graph.length;
        boolean[][] reachable = new boolean[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (graph[i][j] > 0)
                {
                    reachable[i][j] = true;
                }
            }
        }

        for (int k = 0; k < n; k++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    reachable[i][j] = (reachable[i][j] || (reachable[i][k] && reachable[k][j])) ? true : false;
                }
            }
        }
        return reachable;
    }

    public static void main(String[] args)
    {
        int[][] graph = new int[][]{{1, 1, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };
        GraphClosure gc = new GraphClosure();
        boolean[][] closure = gc.findClosure(graph);
        for (int i = 0; i < closure.length; i++)
        {
            for (int j = 0; j < closure[i].length; j++)
            {
                System.out.print(closure[i][j] + " ");
            }
            System.out.println();
        }
    }
}
