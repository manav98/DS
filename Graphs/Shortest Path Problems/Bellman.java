//BELLMAN-FORD ALGORITHM
public class Bellman
{
    static int[] BellFord(int[][] graph, int src)
    {
        int n = graph.length;
        int[] distance = new int[n];
        for (int i = 0; i < n; i++)
            distance[i] = Integer.MAX_VALUE;

        distance[src] = 0;

        for (int i = 0; i < n - 1; i++)
        {
            for (int j = src; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    if (graph[j][k] != 0)
                    {
                        if (distance[j] != Integer.MAX_VALUE && distance[k] > distance[j] + graph[j][k])
                        {
                            distance[k] = distance[j] + graph[j][k];
                        }
                    }
                }
            }
        }
        //checking for negetive loop
        for (int j = src; j < n; j++)
        {
            for (int k = 0; k < n; k++)
            {
                if (graph[j][k] != 0)
                {
                    if (distance[j] != Integer.MAX_VALUE && distance[k] > distance[j] + graph[j][k])
                    {
                        System.out.println("Negetive weight cycle found");
                        break;
                        //return new int[n];
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args)
    {
        int[][] adjmat = {{0, 10, 0, 0, 0, 0, 0, 8},
                {0, 0, 0, 0, 0, 2, 0, 0},
                {0, -1, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, -1, 0, 0},
                {0, 0, -2, 0, 0, 0, 0, 0},
                {0, -4, 0, 0, 0, -1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0}};
        int src = 0;
        int[] shortestPaths = BellFord(adjmat, src);
        System.out.println("Vertex" + "\t" + "Distance");
        for (int i = 0; i < shortestPaths.length; i++)
        {
            System.out.println(i + 1 + "\t" + shortestPaths[i]);
        }
    }
} 
