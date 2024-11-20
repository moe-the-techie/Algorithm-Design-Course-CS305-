import java.util.Scanner;

public class Section5 {
    public static void main (String[] args) {
        // Subject of interest: DP
        int[][] adj = init();
        int[][] path = floyd(adj);
        System.out.print("V1 ");
        printPath(path, 1, 2);
        System.out.print(" V2");
        System.out.println("\n cost: " + adj[1][2]);
    }

    // Initializes adjacent matrix for floyd's algorithm for finding the shortest path
    public static int[][] init () {
        Scanner input = new Scanner(System.in);
        System.out.print("# of vertices: ");
        int nVertices = input.nextInt();
        System.out.print("# of edges: ");
        int nEdges = input.nextInt();
        final int MAX = 1000;

        int[][] adj = new int[nVertices + 1][nVertices + 1];

        for (int i = 1; i < adj.length; i++) {
            for (int j = 1; j < adj[i].length; j++) {
                if (i != j) adj[i][j] = MAX;
            }
        }

        for (int i = 0; i < nEdges; i++) {
            System.out.print("Source: ");
            int source = input.nextInt();
            System.out.print("Destination: ");
            int destination = input.nextInt();
            System.out.print("Weight: ");
            int weight = input.nextInt();

            adj[source][destination] = weight;
        }

        return adj;
    }

    public static int[][] floyd (int[][] weights) {
        int[][] path = new int[weights.length][weights.length];

        for (int k = 1; k < weights.length; k++) {
            for (int i = 1; i < weights.length; i++) {
                for (int j = 1; j < weights.length; j++) {
                    if (weights[i][k] + weights[k][j] < weights[i][j]) {
                        path[i][j] = k;
                        weights[i][j] = weights[i][k] + weights[k][j];
                    }
                }
            }
        }

        return path;
    }

    public static void printPath (int[][] path, int q, int r) {
        if (path[q][r] != 0) {
            printPath(path, q, path[q][r]);
            System.out.print("V" + path[q][r] + " ");
            printPath(path, path[q][r], r);
        }
    }
}
