//KRUSKAL'S ALGORITHM
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MST
{
    static class Edge implements Comparable<Edge>
    {
        int source;
        int destination;
        int weight;

        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    }


    int V;
    int E;
    Edge[] edges;

    void findMST()
    {
        Arrays.sort(edges);
        int[] components = new int[V];
        for(int i=0;i<V;i++)
        {
            components[i] = i;
        }
        int i=0;
        List<Edge> TE = new ArrayList<>();
        Edge curr;
        while (TE.size() < V-1)
        {
            curr = edges[i++];
            if(components[curr.source] != components[curr.destination])
            {
                TE.add(curr);
                for(int j=0;j<V;j++)
                {
                    if(components[j] == components[curr.destination])
                    {
                        components[j] = components[curr.source];
                    }
                }
            }
        }
        int itr=0;
        while (itr < TE.size())
        {
            System.out.println(TE.get(itr).source + "--" + TE.get(itr).destination +" ->" + TE.get(itr).weight);
            itr++;
        }
    }

    public static void main(String[] args)
    {
        int numOfVertices = 4;
        int numOfEdges = 5;
        MST graph = new MST();
        graph.edges = new Edge[numOfEdges];
        int i;
        for (i = 0; i < numOfEdges; i++)   //Memory allocation
        {
            graph.edges[i] = new Edge();
        }
        graph.V = numOfVertices;
        graph.E = numOfEdges;
        graph.edges[0].source = 0;
        graph.edges[0].destination = 3;
        graph.edges[0].weight = 5;

        graph.edges[1].source = 0;
        graph.edges[1].destination = 1;
        graph.edges[1].weight = 10;

        graph.edges[2].source = 1;
        graph.edges[2].destination = 3;
        graph.edges[2].weight = 15;

        graph.edges[3].source = 3;
        graph.edges[3].destination = 2;
        graph.edges[3].weight = 4;

        graph.edges[4].source = 0;
        graph.edges[4].destination = 2;
        graph.edges[4].weight = 6;
        graph.findMST();
    }
}
