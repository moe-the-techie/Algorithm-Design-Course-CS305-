// TODO: write a recursive generic method that finds a target in an array (the one above here is iterative)
import java.util.Scanner;
import java.io.*;

// P1: Get Target
public class Section1 {
    public static void main (String[] args) throws FileNotFoundException {
        printToFile();
    }

    public static <T> boolean getTarget (T target, T[] arr) {
        for (T t : arr) {
            if (t.equals(target)) return true;
        }
        return false;
    }

    //P2: Files!
    public static void printToFile() throws FileNotFoundException {
        File file = new File("C:\\Programming\\Java\\CS 305 (Algorithm design)\\test.txt");
        File outputFile = new File("C:\\Programming\\Java\\CS 305 (Algorithm design)\\test_out.txt");
        // Try-with-resources (useful way of initializing utilities without having to worry about closing them)
        try (Scanner scanner = new Scanner(file); PrintWriter printWriter = new PrintWriter(outputFile)) {
            printWriter.println(scanner.nextLine());
        }
    }

    //P3 (task): array comparison
    public static <T> boolean checkArrays(T[] arr1, T[] arr2) {
        if (arr1 == null || arr2 == null) return false;
        if (arr1.length != arr2.length) return false;
        if (arr1.length == 0) return true;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }
}
