import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

public class Section6 {
    // Approach: Greedy
    // Concept: repeatedly chooses the closest solutions and checks if they are valid.

    /* Question: in the conventional change problem, what makes a set of denominators be valid for greedy to always find
        best solution */

    public static void main(String[] args) {
        int[][] graph = weightedGraph();

        Edge[] edges = prim(graph);

        for (int i = 1; i < edges.length; i++) {
            System.out.println(edges[i]);
        }
    }

    public static int[][] weightedGraph() {
        Scanner input = new Scanner(System.in);
        System.out.print("# of vertices: ");
        int nVertices = input.nextInt();
        System.out.print("# of edges: ");
        int nEdges = input.nextInt();

        int[][] graph = new int[nVertices + 1][nVertices + 1];

        for (int i = 1; i <= nEdges; i++) {
            System.out.print("Source: ");
            int source = input.nextInt();
            System.out.print("Destination: ");
            int destination = input.nextInt();
            System.out.print("Weight: ");
            int weight = input.nextInt();

            graph[source][destination] = weight;
            graph[destination][source] = weight;
        }

        return graph;
    }

    public static Edge[] prim (int[][] weights) {
        int n = weights.length - 1; // # of vertices

        Edge[] edges = new Edge[n]; // # of vertices - 1 + 1 (+1 accommodates for 1 indexing)

        int[] nearest = new int[n+2];
        int[] distance = new int[n+2];

        for (int i = 2; i <= n; i++) {
            nearest[i] = 1;
            distance[i] = weights[1][i];
        }

        int vnear = -1;

        // repeats n - 1 times
        for (int i = 1; i < n; i++) {
            // TODO: fix this, something seems horribly wrong.
            int min = 200;

            for (int j = 2; j < n; j++) {

                if (0 <= distance[j] && distance[j] < min) {
                    min = distance[j];
                    vnear = j;
                }

                Edge edge = new Edge(vnear, nearest[vnear], weights[vnear][nearest[vnear]]);
                edges[i] = edge;
                distance[vnear] = 200;

                for (j = 2; j <= n; j++) {
                    if (weights[j][vnear] < distance[j]) {
                        distance[j] = weights[j][vnear];
                        nearest[j] = vnear;
                    }
                }
            }
        }

        return edges;
    }
}

class Edge implements Comparable<Edge> {
    int from, to, weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public String toString() {
        return "(" + from + ", " + to + ", " + weight + ")";
    }

    @Override
    public int compareTo(Edge other) {
        return weight - other.weight;
    }
}