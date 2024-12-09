import java.io.*;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        PriorityQueue<Node> PQ = new PriorityQueue<Node>((a, b) -> a.frequency - b.frequency);
        File file = new File("C:\\Programming\\Java\\Algorithm Design Course (CS305)\\input.txt");

        try (Scanner scanner = new Scanner(file)) {
            String test = scanner.nextLine();

            // Test counts
            int[] counts = count(test);

            // Populate the priority queue with nodes (not the most efficient approach, but should do for now
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    PQ.add(new Node((char) (i + (int) 'a'), counts[i]));
                }
            }

            // Test both huffman and printCode
            printCode(huffman(PQ), "");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }


    }

    public static Node huffman(PriorityQueue<Node> PQ) {

        while (PQ.size() > 1) {
            Node left = PQ.poll();
            Node right = PQ.poll();

            Node newNode = new Node('$', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;

            PQ.add(newNode);
        }

        return PQ.poll();
    }

    public static void printCode(Node root, String str) {
        if (root == null) return;

        if (root.left == null & root.right == null && Character.isLetter(root.symbol)) {
            System.out.println(root.symbol + ": " + str);
            return;
        }

        printCode(root.left, str + "0");
        printCode(root.right, str + "1");

    }

    public static int[] count(String input) {
        input = input.replace(" ", "").toLowerCase();
        int[] counts = new int[26];

        for (int i = 0; i < input.length(); i++) {
            counts[input.charAt(i) - 'a']++;
        }

        return counts;
    }
}

class Node {
    char symbol;
    int frequency;
    Node left;
    Node right;

    public Node (char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
        this.left = this.right = null;
    }

    public String toString() {
        return symbol + "";
    }
}
