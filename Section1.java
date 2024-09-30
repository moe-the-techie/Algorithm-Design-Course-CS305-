import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Section1 {
    public static void main (String[] args) throws FileNotFoundException {
        // P1 testing.
        String[] test1 = {"Hello", "how", "are", "you?"};
        String target1 = "are";
        System.out.println("test1: " + getTarget(target1, test1));

        // P2 testing.
        Integer[] test2 = {1,32,134,23};
        int target2 = 15;
        System.out.println("test2: " + getTargetRecursive(target2, test2));

        // P3 testing.
        printToFile();

        // P4 testing.
        Integer[] test3 = {1,2,12,-34};
        Integer[] test4 = {1,2,12,-34};
        System.out.println("test4: " + checkArrays(test3, test4));
    }

    // P1: Find target in array (iterative)
    public static <T> boolean getTarget (T target, T[] arr) {
        for (T t : arr) {
            if (t.equals(target)) return true;
        }
        return false;
    }

    // P2 (HW): Find target in array (recursive)
    public static <T> boolean getTargetRecursive(T target, T[] arr) {
        if (arr.length == 0) return false;
        if (arr[0].equals(target)) return true;
        T[] newArr = Arrays.copyOfRange(arr, 1, arr.length);
        return getTarget(target, newArr);
    }

    // P3: Files!
    public static void printToFile() {
        File file = new File("C:\\Programming\\Java\\Algorithm Design Course (CS305)\\test.txt");
        File outputFile = new File("C:\\Programming\\Java\\Algorithm Design Course (CS305)\\test_out.txt");
        // Try-with-resources (useful way of initializing utilities without having to worry about closing them)
        try (Scanner scanner = new Scanner(file); PrintWriter printWriter = new PrintWriter(outputFile)) {
            printWriter.println(scanner.nextLine());
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    // P4 (task): array comparison
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
