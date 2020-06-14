//KRUSKAL'S ALGORITHM
//UNION HEAP IMPLEMENTATION PENDING

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MSTpending
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


    int V;  //number of Vertices
    int E;  //number of edges
    Edge[] edges;

    static void makeUnionFind(int[] components, int[] componentsSize, List<Edge>[] members)
    {
        MST ob = new MST();
        for (int i = 0; i < components.length; i++)
        {
            components[i] = i;
            componentsSize[i] = 1;
            members[i] = new ArrayList<Edge>();
            members[i].add(ob.edges[i]);
        }
    }

    static void merge(List<Edge> m1, List<Edge> m2, int[] componentSize)
    {
        int i = 0;
        if (m1.size() < m2.size())
        {
            while (i < m1.size())
            {
                m2.add(m1.get(i));
                i++;
                componentSize[m2]++;
            }
        }
        else
        {
            while (i < m2.size())
            {
                m1.add(m2.get(i));
                i++;
            }
        }
    }

    void findMST()
    {
        Arrays.sort(edges);
        int[] components = new int[V];
        int[] componentSize = new int[V];
        List<Edge>[] members = new ArrayList[V]; //lists of members of every component
        makeUnionFind(components, componentSize, members);
        int i = 0;
        List<Edge> TE = new ArrayList<>();
        Edge curr;
        while (TE.size() < V - 1)
        {
            curr = edges[i++];
            if (components[curr.source] != components[curr.destination])
            {
                TE.add(curr);
                merge(members[curr.source], members[curr.destination], componentSize);
            }
        }
        int itr = 0;
        while (itr < TE.size())
        {
            System.out.println(TE.get(itr).source + "--" + TE.get(itr).destination + " ->" + TE.get(itr).weight);
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
