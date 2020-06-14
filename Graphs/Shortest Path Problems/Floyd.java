//FLOYD-WARSHALL ALGORITHM
class Floyd
{
    final static int INF = 9999;

    static int[][] floyd(int[][] adjmat)
    {
        int n = adjmat.length;
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                mat[i][j] = adjmat[i][j];
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 1; k < n; k++)
                {
                    if (mat[j][k] > mat[j][i] + mat[i][k])
                    {
                        mat[j][k] = mat[j][i] + mat[i][k];
                    }
                }
            }
        }
        return mat;
    }

    public static void main(String[] args)
    {
        int[][] adjmat = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}};

        int[][] solution = floyd(adjmat);//FIND ALL PAIR SHORTEST PATHS
        for (int i = 0; i < solution.length; i++)
        {
            for (int j = 0; j < solution.length; j++)
            {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
