//Number of Islands
class Islands
{
    private boolean isSafe(int[][] adjMat, boolean[][] visited, int row, int col)
    {
        return ((row >= 0) && (row < adjMat.length) && (col >= 0) && (col < adjMat.length) && (adjMat[row][col] == 1) && (!visited[row][col]));
    }

    private void dfs(int[][] adjMat, boolean[][] visited, int i, int j)
    {
        visited[i][j] = true;
        int[] rowNbr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colNbr = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        for (int k = 0; k < 8; k++)
        {
            if (isSafe(adjMat, visited, i + rowNbr[k], j + colNbr[k]))
                dfs(adjMat, visited, i + rowNbr[k], j + colNbr[k]);
        }
    }

    private int countComponents(int[][] adjMat)
    {
        int components = 0;
        boolean[][] visited = new boolean[adjMat.length][adjMat[0].length];
        for (int i = 0; i < adjMat.length; i++)
        {
            for (int j = 0; j < adjMat[0].length; j++)
            {
                if (!visited[i][j] && adjMat[i][j] == 1)
                {
                    dfs(adjMat, visited, i, j);
                    components++;
                }
            }
        }
        return components;
    }

    public static void main(String[] args)
    {
        int[][] M = {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        Islands cc = new Islands();
        int components = cc.countComponents(M);
        System.out.println(components);
    }
}
