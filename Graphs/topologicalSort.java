import java.util.LinkedList;
import java.util.Queue;

class topologicalSort {

	static int[] tpSort(int[][] adjList) {
		int n = adjList.length;
		int[] indegree = new int[n];
		int[] sol = new int[n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < adjList[i].length; j++) {
				indegree[adjList[i][j]]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		int temp;
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();
			sol[k] = temp;
			k++;
			for (int z = 0; z < adjList[temp].length; z++) {
				indegree[adjList[temp][z]]--;
				if (indegree[adjList[temp][z]] == 0) {
					q.add(adjList[temp][z]);
				}
			}

		}
		return sol;
	}

	public static void main(String[] args) {
		int[][] adjList = { { 2, 3, 4 }, { 2, 7 }, { 5 }, { 5, 7 }, { 7 }, { 6 }, { 7 }, {} };
		int[] top = new int[adjList.length];
		top = tpSort(adjList);
		System.out.println("Solution is");
		for (int i = 0; i < top.length; i++) {
			System.out.println(top[i] + 1);
		}
	}
}
