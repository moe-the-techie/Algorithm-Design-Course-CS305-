import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Section7 {
    public static void main(String[] args) {
        Edge e1 = new Edge(3, 2, 1);
        Edge e2 = new Edge(2, 4, 3);
        Edge e3 = new Edge(1,2,2);
        ArrayList<Edge> list = new ArrayList<Edge>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        System.out.println(list);
        list.sort(null);
        System.out.println(list);


    }

    public static Edge[] kruskal (int[] V, Edge[] E) {
        // This needs a lot more work, TODO: correct this entire file.
        int n = V.length;
        int m = E.length;
        Edge[] solution = new Edge[m];

        Set<Integer>[] sets = new Set[n];

        for (int i = 0; i < n; i++) {
            sets[i].add(V[i]);
        }

        // Copy E to ArrayList

        ArrayList<Edge> edges = new ArrayList<>(Arrays.asList(E));

        return solution;
    }
}
